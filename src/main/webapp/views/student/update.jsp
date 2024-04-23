<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/6/2024
  Time: 6:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student Account</title>
    <jsp:include page="/fragments/css.jsp" />

</head>
<body>
<jsp:include page="/fragments/navbar.jsp" ></jsp:include>


<form method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Student FullName</label>
        <input type="text" class="form-control" id="name" name="name" value="${student.getFullName()}">
    </div>
    <div class="mb-3">
        <label for="groupid" class="form-label">Student GroupID</label>
        <input type="number" class="form-control" id="groupid" name="groupid" value="${student.getGroupID()}">
    </div>
    <div class="mb-3">
        <label for="age" class="form-label">Student Age</label>
        <input type="number" class="form-control" id="age" name="age" value="${student.getAge()}">
    </div>

    <button type="submit" class="btn btn-success">Update</button>
    <a href="/" class="btn btn-warning">Back</a>
</form>


<jsp:include page="/fragments/js.jsp" ></jsp:include>
</body>
</html>
