package com.sunzehai.mywebsite.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.pegdown.PegDownProcessor;

import com.sunzehai.mywebsite.model.database.Article;

public class MarkdownService {
	
	private static MarkdownService instance;
	
	private PegDownProcessor processor = new PegDownProcessor();
	
	private MarkdownService() {
		
	}
	
	public static MarkdownService getInstance() {
		if (instance == null) {
			instance = new MarkdownService();
		}
		return instance;
	}
	
	public String getAticleHtml(ServletContext context, Article article) throws IOException {
		String result = "";
		
		Path path = Paths.get(context.getRealPath("/articles/" + article.getId() + ".md"));
		String markdownSource = Files.lines(path, Charset.forName("utf-8")).collect(Collectors.joining("\n"));
		result = processor.markdownToHtml(markdownSource);
		
		return result;
	}
	
}
