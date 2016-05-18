<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>JavaRush test project</title>
</head>
<body>
    <ul>
<c:forEach items="${userList}" var="user" >
        <li id="user_<c:out value="user.id"/>">
            <div class="userName">
                <c:out value="${user.name}" />
            </div>
            <div>
                <span class="userTime"><c:out value="${user.createdDate}" /></span>
<span class="userOther">
(<c:out value="${user.admin}" />,
<c:out value="${user.age}" />)</span>
            </div>
        </li>
</c:forEach>
    </ul>
</body>
</html>
