<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<h1>Users Data</h1>
	<form:form action="user.do" method="POST" commandName="user">
		<table>
			<tr>
				<td>User ID</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>User name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>User age</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Is Admin</td>
				<td><form:input path="isAdmin" /></td>
			</tr>
			<tr>
				<td>Create Date</td>
				<td><form:input path="createDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" /> <input
					type="submit" name="action" value="Delete" /> <input type="submit"
					name="action" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<table border="1">
		<th>ID</th>
		<th>Name</th>
		<th>Age</th>
		<th>isAdmin</th>
		<th>Create Date</th>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.isAdmin}</td>
				<td>${user.createDate}</td>
			</tr>
		</c:forEach>
	</table>

	<div id="pagination">

		<c:url value="list" var="prev">
			<c:param name="page" value="${page-1}" />
		</c:url>
		<c:if test="${page > 1}">
			<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
		</c:if>

		<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="/user/list" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/user/list" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>




</body>
</html>