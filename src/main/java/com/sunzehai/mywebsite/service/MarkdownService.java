package com.sunzehai.mywebsite.service;

import org.pegdown.PegDownProcessor;

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
	
//	public String getAticleHtml(ServletContext context, Article article) throws IOException {
//		String result = "";
//		
//		Path path = Paths.get(context.getRealPath("/articles/" + article.getId() + ".md"));
//		String markdownSource = Files.lines(path, Charset.forName("utf-8")).collect(Collectors.joining("\n"));
//		result = processor.markdownToHtml(markdownSource);
//		
//		return result;
//	}
	
}
