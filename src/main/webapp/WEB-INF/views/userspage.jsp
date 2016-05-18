<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Users List</title>
</head>
<body>
<h1>Users</h1>

<c:url var="addUrl" value="/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
  <thead style="background:#fcf">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>age</th>
    <th>isAdmin</th>
    <th>createdDate</th>
    <th colspan="2"></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${userList}" var="user">
    <c:url var="editUrl" value="/edit?id=${user.id}" />
    <c:url var="deleteUrl" value="/delete?id=${user.id}" />
    <tr>
      <td><c:out value="${user.id}" /></td>
      <td><c:out value="${user.name}" /></td>
      <td><c:out value="${user.age}" /></td>
      <td><c:out value="${user.admin}" /></td>
      <td><c:out value="${user.createdDate}" /></td>
      <td><a href="${editUrl}">Edit</a></td>
      <td><a href="${deleteUrl}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:if test="${empty userList}">
  There are currently no persons in the list.
</c:if>
<a href="${addUrl}">Add</a> a person.

</body>
</html>