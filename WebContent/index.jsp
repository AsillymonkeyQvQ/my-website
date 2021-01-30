<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/global.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/main-homepage.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/font-awesome.css">
        <title>孙泽海的个人网站主页</title>
    </head>
    <body>
    	<!-- header -->
		<%@ include file="include/header.jsp" %>
		
		<!-- main -->
		<main id="main-homepage">
			<section class="topic">
				<c:forEach var="article" items="${applicationScope.articles}" begin="0" end="0">
					<img src="${contextPath}/images/${article.id}.jpg"/>
					<div class="topic-content-wrapper">
	                   <div class="content-type">${article.category}</div>
	                   <h1 class="content-heading"><a href="${contextPath}/article/${article.id}">${article.title}</a></h1>
	                   <p class="content-body">${article.description}</p>
	                   <p class="etc">...</p>
		            </div>
			    </c:forEach>
			</section>
			
			<section class="articles">
				<c:forEach var="article" items="${applicationScope.articles}" begin="1" end="4">
					<article class="article">
	                    <img src="${contextPath}/images/${article.id}.jpg"/>
	                    <div class="article-content-wrapper">
	                        <div class="content-type">${article.category}</div>
	                    <h1 class="content-heading"><a href="${contextPath}/article/${article.id}">${article.title}</a></h1>
	                    <p class="content-body">${article.description}</p>
	                    </div>
	                </article>
				</c:forEach>
            </section>
            
            <section class="newsletter">
                <p>Sign up for my newsletter!</p>
                <div class="email">
                    <div class="email-input">Enter a valid email address</div>
                    <div class="email-submit"><i class="far fa-paper-plane"></i></div>
                </div>
            </section>
            
            <section class="articles">
				<c:forEach var="article" items="${applicationScope.articles}" begin="5" end="6">
					<article class="article">
	                    <img src="${contextPath}/images/${article.id}.jpg"/>
	                    <div class="article-content-wrapper">
	                        <div class="content-type">${article.category}</div>
	                    <h1 class="content-heading"><a href="${contextPath}/article/${article.id}">${article.title}</a></h1>
	                    <p class="content-body">${article.description}</p>
	                    </div>
	                </article>
				</c:forEach>
            </section>
            
            <section class="more">
                <button class="load-more">Load more</button>
            </section>
		</main>
		
		<!-- footer -->
		<%@ include file="include/footer.jsp"%>	
    </body>
</html>
