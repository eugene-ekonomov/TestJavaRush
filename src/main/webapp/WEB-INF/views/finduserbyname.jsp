<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
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
    <c:forEach items="${userList}" var="user">
  <tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>${user.admin}</td>
    <td>${user.createdDate}</td>
    <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
    <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
  </tr>
  </c:forEach>
  </tr>
  </tbody>
</table>
</body>
</html>