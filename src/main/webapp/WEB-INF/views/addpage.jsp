<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Create New User</title>
</head>
<body>

<h1>Create New User</h1>
<c:url var="saveUrl" value="add" />
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
  <table>
    <tr>
      <td><form:label path="name">name:</form:label></td>
      <td><form:input path="name"/></td>
    </tr>

    <tr>
      <td><form:label path="age">age</form:label></td>
      <td><form:input path="age"/></td>
    </tr>

    <tr>
      <td><form:label path="admin">isAdmin</form:label></td>
      <td><form:checkbox path="admin" /></td>
    </tr>
  </table>

  <input type="submit" value="Save" />
</form:form>

</body>
</html>