<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/global.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/main-category.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/font-awesome.css"/>
		<script type="text/javascript" src="${contextPath}/js/category.js"></script>
		<title>${requestScope.category.name}</title>
	</head>
	<body>
		<!-- header -->
		<%@ include file="../include/header.jsp" %>
		
		<!-- main -->
		<main id="main-category">
			<section class="sub-categories">
				<span>CATEGORY:</span>
				<ul>
					<li <c:if test="${requestScope.currentSubCategory == null}">class="current"</c:if>><a href="${contextPath}/category/${category.id}">ALL(${viewCategoryArticleCountsMap[category.id].counts})</a></li>
					<c:forEach var="subCategory" items="${requestScope.subCategories}">
						<li <c:if test="${requestScope.currentSubCategory.id == subCategory.id}">class="current"</c:if>><a href="${contextPath}/category/${category.id}?subCategory=${subCategory.id}">${subCategory.name}(${viewCategoryArticleCountsMap[subCategory.id].counts})</a></li>
					</c:forEach>
				</ul>
			</section>
			<section class="articles">
				<c:forEach var="article" items="${requestScope.articles}">
					<%@ include file="../include/article.jsp" %>
				</c:forEach>
			</section>
		</main>
		
		<!-- footer -->
		<%@ include file="../include/footer.jsp" %>
		
		<!-- hidden area -->
		<span id="ctx">${contextPath}</span>
	</body>
</html>