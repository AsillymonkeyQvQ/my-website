<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="shortcut icon" href="${contextPath}/images/favicon.svg">
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/global.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/font-awesome.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/main-article.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/github-markdown.css"/>
		<title>${requestScope.article.title}</title>
	</head>
	<body>
		<!-- header -->
		<%@ include file="../include/header.jsp" %>
		
		<!-- main -->
		<main id="main-article">
			<section class="article-wrapper">
				<img alt="${requestScope.article.title}" src="${contextPath}/images/${requestScope.article.banner}">
				<article class="markdown-body">
					${html}
				</article>
			</section>
		</main>
		
		<!-- footer -->
		<%@ include file="../include/footer.jsp" %>
	</body>
</html>
