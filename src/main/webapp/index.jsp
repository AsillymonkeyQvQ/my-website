<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8"/>
        <link rel="shortcut icon" href="${contextPath}/images/favicon.svg">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/global.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/main-homepage.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/font-awesome.css">
        <script type="text/javascript" src="${contextPath}/js/homepage.js"></script>
        <title>孙泽海的个人网站主页</title>
    </head>
    <body>
    	<!-- header -->
		<%@ include file="include/header.jsp" %>
		
		<!-- main -->
		<main id="main-homepage">
			<section class="topic">
				<c:forEach var="article" items="${applicationScope.articles}" begin="0" end="0">
					<%@ include file="include/article.jsp" %>
				</c:forEach>
			</section>
			
			<section class="articles">
				<c:forEach var="article" items="${applicationScope.articles}" begin="1" end="4">
					<%@ include file="include/article.jsp" %>
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
					<%@ include file="include/article.jsp" %>
				</c:forEach>
            </section>
            
            <section class="more">
                <button class="load-more">Load more</button>
            </section>
		</main>
		
		<!-- footer -->
		<%@ include file="include/footer.jsp"%>
		
		<!-- hidden area -->
		<span id="ctx">${contextPath}</span>
    </body>
</html>
