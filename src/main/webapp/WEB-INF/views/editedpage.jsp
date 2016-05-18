<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Result Page</title>
</head>
<body>

<h1>Users</h1>
<p>You have edited a user with id ${id} at <%= new java.util.Date() %></p>

<c:url var="usersUrl" value="/users" />
<p>Return to <a href="${usersUrl}">List</a></p>

</body>
</html>