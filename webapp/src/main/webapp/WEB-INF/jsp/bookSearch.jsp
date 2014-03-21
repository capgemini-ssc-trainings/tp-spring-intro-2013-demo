<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<sf:form method="POST" action="bookSearch"
	modelAttribute="bookSearchCriteria">

	<table cellspacing="0">
		<tr>
			<td>Author:</td>
			<td><sf:input path="author" size="15" />
			</td>
			<td><sf:errors path="author" />
			</td>
		</tr>
		<tr>
			<td>Title:</td>
			<td><sf:input path="title" size="15" />
			</td>
			<td><sf:errors path="title" />
			</td>
		</tr>
		<tr>
			<td>Publication year:</td>
			<td><sf:input path="publicationYear" size="15" />
			</td>
			<td><sf:errors path="publicationYear" />
			</td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Search" />
			</td>
		</tr>
	</table>
</sf:form>




