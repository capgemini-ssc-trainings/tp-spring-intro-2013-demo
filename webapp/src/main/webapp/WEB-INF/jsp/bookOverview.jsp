<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<table cellspacing="0">
	<tr>
		<th>Author</th>
		<th>Title</th>
		<th>Publiced</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="book" items="${bookList}">
		<tr>
			<td><s:message text="${book.title}" />
			</td>
			<td><s:message text="${book.author}" />
			</td>
			<td><s:message text="${book.publicationYear}" />
			</td>
			<td><c:url value="/bookView" var="viewUrl">
					<c:param name="id" value="${book.id}" />
				</c:url> <a href="${viewUrl}">View</a></td>
		</tr>
	</c:forEach>
</table>

</br>
<a href="bookSearch">&lt;-- Refine your criteria</a>
</br>
<a href="newBookSearch">&lt;-- New search</a>
