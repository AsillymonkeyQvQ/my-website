<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header id="header">
    <div class="logo">
        <a href="${contextPath}">Asillymonkey</a>
    </div>
    <nav class="navigation">
        <ul>
        	<c:forEach var="category" items="${applicationScope.categorys}">
        		<li><a href="${contextPath}/category/${category.name}">${category.name}</a></li>
        	</c:forEach>
        </ul>
    </nav>
</header>
