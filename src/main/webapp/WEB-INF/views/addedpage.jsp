<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Added Page</title>
</head>
<body>

<h1>Added</h1>
<p>You have added a new person at <%= new java.util.Date() %></p>

<c:url var="usersUrl" value="/users" />
<p>Return to <a href="${usersUrl}">User List</a></p>

</body>
</html>