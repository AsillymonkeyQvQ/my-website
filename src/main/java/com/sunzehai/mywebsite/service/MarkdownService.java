package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Article;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MarkdownService {
	
	private static MarkdownService instance;

	private MarkdownService() {
		
	}
	
	public static MarkdownService getInstance() {
		if (instance == null) {
			instance = new MarkdownService();
		}
		return instance;
	}
	
	public String getAticleHtml(ServletContext context, Article article) throws IOException {
		StringBuilder builder = new StringBuilder();

		Path path = Paths.get(context.getRealPath(String.format("/articles/%d/%d.md", article.getId(), article.getId())));
		String text = Files.lines(path, Charset.forName("utf-8"))
				             .map(s -> s.replaceAll("images/", String.format("%s/articles/%d/images/", context.getContextPath(), article.getId())))
							 .collect(Collectors.joining("\\n"));
		String json = String.format("{\"text\":\"%s\"}", text);

		path = Paths.get(context.getRealPath(String.format("/articles/%d/%d.json", article.getId(), article.getId())));
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toFile())))) {
			writer.write(json);
			writer.flush();
		}

		String cmd = "curl -X POST -H \"Accept: application/vnd.github.v3+json\" https://api.github.com/markdown -d @" + path.toRealPath();
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(cmd);
		try {
			process.waitFor();
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append("\n");
			}
		}

		return builder.toString();
	}
	
}
