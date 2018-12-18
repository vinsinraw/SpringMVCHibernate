<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring 4 MVC Hibernate4 - Book CRUD</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Book
</h1>

<c:url var="addAction" value="/book/add" ></c:url>

<form:form action="${addAction}" commandName="book">
<table>
	<c:if test="${!empty book.bookName}">
	<tr>
		<td>
			<form:label path="id" cssClass="bookLabel">
				<spring:message code="label.bookId" />
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="bookName" cssClass="bookLabel">
				<spring:message code="label.bookName" />
			</form:label>
		</td>
		<td>
			<form:input path="bookName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="author" cssClass="bookLabel">
				<spring:message code="label.author" />
			</form:label>
		</td>
		<td>
			<form:input path="author" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="price" cssClass="bookLabel">
				<spring:message code="label.price" />
			</form:label>
		</td>
		<td>
			<form:input path="price" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="quantity" cssClass="bookLabel">
				<spring:message code="label.qty" />
			</form:label>
		</td>
		<td>
			<form:input path="quantity" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty book.bookName}">
				<input type="submit"
					value="<spring:message code="label.editbook"/>" />
			</c:if>
			<c:if test="${empty book.bookName}">
				<input type="submit"
					value="<spring:message code="label.addbook"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Books List</h3>

<c:if test="${!empty bookList}">
	<table class="tg">
	<tr>
		<th width="180">Book Name</th>
		<th width="160">Author Name</th>
		<th width="60">Price</th>
		<th width="80">Quantity</th>
		<th colspan="2" width="120">Action</th>
	</tr>
	
	<c:forEach items="${bookList}" var="book">
		<tr>
			<td><a href="<c:url value='/edit/${book.id}' />" >${book.bookName}</a></td>
			<td>${book.author}</td>
			<td>${book.price}</td>
			<td>${book.quantity}</td>
			<td><a href="<c:url value='/edit/${book.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${book.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>	
</c:if>

</body>
</html>
