<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Edit User</title>
</head>
<body>

<h1>Edit Person</h1>
<c:url var="saveUrl" value="/edit?id=${userAttribute.id}" />
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
  <table>
    <tr>
      <td><form:label path="id">id:</form:label></td>
      <td><form:input path="id" disabled="true"/></td>
    </tr>

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

    <tr>
      <td><form:label path="createdDate">createdDate:</form:label></td>
      <td><form:input path="createdDate" disabled="true"/></td>
    </tr>
  </table>

  <input type="submit" value="Save" />
</form:form>

</body>
</html>