<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="shortcut icon" href="${contextPath}/images/favicon.svg">
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
				<c:forEach var="article" items="${requestScope.pager.dataList}">
					<%@ include file="../include/article.jsp" %>
				</c:forEach>
			</section>
			<section class="pagination">
				<ul>
					<li><a href="${contextPath}/category/${category.id}?<c:if test="${currentSubCategory != null}">subCategory=${currentSubCategory.id}&</c:if>currentPage=${pager.currentPage - 1 < 1 ? 1 : pager.currentPage - 1}">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${pager.totalPage}">
						<li><a href="${contextPath}/category/${category.id}?<c:if test="${currentSubCategory != null}">subCategory=${currentSubCategory.id}&</c:if>currentPage=${i}">${i}</a></li>
					</c:forEach>
					<li><a href="${contextPath}/category/${category.id}?<c:if test="${currentSubCategory != null}">subCategory=${currentSubCategory.id}&</c:if>currentPage=${pager.currentPage + 1 > pager.totalPage ? pager.totalPage : pager.currentPage + 1}">&raquo;</a></li>
				</ul>
			</section>
		</main>
		
		<!-- footer -->
		<%@ include file="../include/footer.jsp" %>
		
		<!-- hidden area -->
		<span id="ctx">${contextPath}</span>
	</body>
</html>