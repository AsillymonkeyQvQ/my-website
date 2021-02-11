<%@ page contentType="text/html; charset=utf-8" %>

<article class="article" data-article-id="${article.id}">
	<img src="${contextPath}/images/${article.banner}"/>
	<div class="article-content-wrapper">
		<div class="article-category">${article.categoryName}</div>
		<h1 class="article-title">${article.title}</h1>
		<p class="article-description">${article.summary}</p>
	</div>
</article>