<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/6/2024
  Time: 6:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Group</title>
    <jsp:include page="/fragments/css.jsp" />
</head>
<body>
<h1>Home Page</h1>
<jsp:include page="/fragments/navbar.jsp" ></jsp:include>

<form method="post">
    <div class="alert alert-danger">

        <h1>Are you sure to delete this Group  <i><c:out value="${group.getName()}"></c:out> </i> ?</h1>
    </div>

    <a href="/" class="btn btn-warning">Back</a>
    <button type="submit" class="btn btn-success">Yes</button>
</form>


<jsp:include page="/fragments/js.jsp" ></jsp:include>

</body>
</html>
