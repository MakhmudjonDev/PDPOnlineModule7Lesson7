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
    <title>Create Group</title>
    <jsp:include page="/fragments/css.jsp" />
</head>
<body>
<h1>Home Page</h1>
<jsp:include page="/fragments/navbar.jsp" ></jsp:include>

<form method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Group Name</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="mb-3">
        <label for="count" class="form-label">Student Count</label>
        <input type="number" class="form-control" id="count" name="count">
    </div>


    <button type="submit" class="btn btn-success">Save</button>
</form>


<jsp:include page="/fragments/js.jsp" ></jsp:include>

</body>
</html>
