<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sunzehai.mywebsite.model.database.Category" %>

<%
	@SuppressWarnings("unchecked")
	List<Category> categorys = (List<Category>)application.getAttribute("categorys");
%>

<header id="header">
    <div class="logo">
        <a href="<%= request.getContextPath() %>">Asillymonkey</a>
    </div>
    <nav class="navigation">
        <ul>
	<%
		for(Category category : categorys) {
	%>
			<li><a href="<%= request.getContextPath() %>/category/<%=category.getName() %>"><%=category.getName() %></a></li>
	<%
		}
	%>
        </ul>
    </nav>
</header>