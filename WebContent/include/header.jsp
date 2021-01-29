<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sunzehai.mywebsite.model.database.Category" %>

<%
	@SuppressWarnings("unchecked")
	List<Category> categorys = (List<Category>)application.getAttribute("categorys");
%>

<header id="header">
    <div class="logo">
        <a href="${pageContext.request.contextPath}">Asillymonkey</a>
    </div>
    <nav class="navigation">
        <ul>
	<%
		for(Category category : categorys) {
	%>
			<li><a href="${pageContext.request.contextPath}/category/<%=category.getName() %>"><%=category.getName() %></a></li>
	<%
		}
	%>
        </ul>
    </nav>
</header>