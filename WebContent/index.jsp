<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sunzehai.mywebsite.model.database.Article" %>

<%
	@SuppressWarnings("unchecked")
	List<Article> articles = (List<Article>)application.getAttribute("articles");
	Iterator<Article> iterator = articles.iterator();
	Article article = iterator.next();
%>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/global.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main-homepage.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.css">
        <title>孙泽海的个人网站主页</title>
    </head>
    <body>
    	<!-- header -->
		<%@ include file="include/header.jsp" %>
		
		<!-- main -->
		<main id="main-homepage">
			<section class="topic">
				<img src="<%=request.getContextPath() %>/images/<%=article.getId() %>.jpg"/>
				<div class="topic-content-wrapper">
                    <div class="content-type"><%=article.getCategory() %></div>
                    <h1 class="content-heading"><a href="<%=request.getContextPath() + "/article/" + article.getId() %>"><%=article.getTitle() %></a></h1>
                    <p class="content-body"><%=article.getDescription() %></p>
                    <p class="etc">...</p>
                </div>
			</section>
			
			<section class="pieces">
			<%
				for (int i = 0; i < 4; i++) {
					if (iterator.hasNext()) {
						article = iterator.next();
			%>
				<div class="piece">
                    <img src="<%=request.getContextPath() %>/images/<%=article.getId() %>.jpg"/>
                    <div class="piece-content-wrapper">
                        <div class="content-type"><%=article.getCategory() %></div>
                    <h1 class="content-heading"><a href="<%=request.getContextPath() + "/article/" + article.getId() %>"><%=article.getTitle() %></a></h1>
                    <p class="content-body"><%=article.getDescription() %></p>
                    </div>
                </div>
			<%
					}
				}
			%>
            </section>
            
            <section class="newsletter">
                <p>Sign up for my newsletter!</p>
                <div class="email">
                    <div class="email-input">Enter a valid email address</div>
                    <div class="email-submit"><i class="far fa-paper-plane"></i></div>
                </div>
            </section>
            
            <section class="pieces">
			<%
				for (int i = 0; i < 2; i++) {
					if (iterator.hasNext()) {
						article = iterator.next();
			%>
				<div class="piece">
                    <img src="<%=request.getContextPath() %>/images/<%=article.getId() %>.jpg"/>
                    <div class="piece-content-wrapper">
                        <div class="content-type"><%=article.getCategory() %></div>
                    <h1 class="content-heading"><a href="<%=request.getContextPath() + "/article/" + article.getId() %>"><%=article.getTitle() %></a></h1>
                    <p class="content-body"><%=article.getDescription() %></p>
                    </div>
                </div>
			<%
					}
				}
			%>
            </section>
            
            <section class="more">
                <button class="load-more">Load more</button>
            </section>
		</main>
		
		<!-- footer -->
		<%@ include file="include/footer.jsp"%>	
    </body>
</html>
