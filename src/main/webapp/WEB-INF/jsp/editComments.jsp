<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/navbar2.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">更新貼文</h1>
<!-- 		<div class="btn-toolbar mb-2 mb-md-0"> -->
<%-- 			<a href="${contextRoot}/employee"><button type="button" --%>
<!-- 					class="btn btn-sm btn-outline-secondary"> -->
<!-- 					<span data-feather="calendar"></span> 新增貼文 -->
<!-- 				</button></a> -->
<!-- 		</div> -->
	</div>
</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">

	<div class="row justify-content-center">
		<div class="col-9">
			<h1>更新貼文</h1>
			<div class="card">
				<div class="card-header">請輸入</div>
				<div class="card-body">

					<form:form class="form" method="post" modelAttribute="commemt">

						<form:input path="id" type="hidden" />
						<form:input path="name" type="hidden" />
						<%--   <form:input path="createondate" type="hidden" /> --%>

						<div class="form-group">
							<form:textarea path="title" class="form-control" />
						</div>
						<div class="form-group">
							<form:textarea path="content" class="form-control" />
						</div>


						<input type="submit" name="submit" value="更新">

					</form:form>

				</div>
			</div>

		</div>

	</div>
</div>