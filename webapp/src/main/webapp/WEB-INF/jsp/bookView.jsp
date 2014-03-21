<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<table cellspacing="0">
	<tr>
		<td>Author:</td>
		<td><s:message text="${book.author}" />
		</td>
	</tr>
	<tr>
		<td>Title:</td>
		<td><s:message text="${book.title}" />
		</td>
	</tr>
	<tr>
		<td>Publication year:</td>
		<td><s:message text="${book.publicationYear}" />
		</td>
	</tr>
</table>

</br>
<a href="bookOverview">&lt;-- Back to search results</a>
</br>
<a href="bookSearch">&lt;-- Refine your criteria</a>
</br>
<a href="newBookSearch">&lt;-- New search</a>