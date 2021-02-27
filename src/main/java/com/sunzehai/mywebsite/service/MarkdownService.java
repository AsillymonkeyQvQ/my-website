package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Article;

import javax.servlet.ServletContext;
import java.io.IOException;

public interface MarkdownService {

    String getArticleHtml(ServletContext context, Article article) throws IOException;

}
