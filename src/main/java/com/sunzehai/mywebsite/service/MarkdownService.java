package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.util.ConfigUtil;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
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

		Path articlePath = Paths.get(context.getRealPath("/articles")).resolve(String.format("%04d", article.getId()));

		Path markdownPath = articlePath.resolve(String.format("%s.md", article.getTitle()));
		String text = Files.lines(markdownPath, StandardCharsets.UTF_8)
				             .map(s -> s.replaceAll("images/", String.format("%s/articles/%04d/images/", context.getContextPath(), article.getId())))
							 .collect(Collectors.joining("\\n"));
		String json = String.format("{\"text\":\"%s\"}", text);

		Path tmpFilePath = articlePath.resolve(String.format("%04d.json", article.getId()));
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFilePath.toFile())))) {
			writer.write(json);
			writer.flush();
		}

		String cmd = "curl -X POST -H \"Accept: application/vnd.github.v3+json\" https://api.github.com/markdown -d @" + tmpFilePath.toRealPath();
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
