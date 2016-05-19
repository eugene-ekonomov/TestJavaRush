<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Users</title>
</head>
<body>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>isAdmin</th>
    <th>createdDate</th>
  </tr>
  </thead>
  <tbody>
  <tr>
  <tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>${user.admin}</td>
    <td>${user.createdDate}</td>
    <td><a href="<c:url value='/edit?id=${user.id}'/>">Edit</a></td>
    <td><a href="<c:url value='/delete?id=${user.id}'/>">Delete</a></td>
  </tr>
  </tr>
  </tbody>
</table>

<c:url var="usersUrl" value="/users/1" />
<p>Return to <a href="${usersUrl}">User List</a></p>
</body>
</html>