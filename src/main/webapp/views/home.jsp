<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/5/2024
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List Page</title>
    <jsp:include page="/fragments/css.jsp" />
</head>
<body>
    <h1>Home Page</h1>
    <jsp:include page="/fragments/navbar.jsp" ></jsp:include>

    <h2 class="text-center my-3">Student Table</h2>
    <div class="container mt-5" >

        <div class="row">

            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Full Name</th>
                        <th scope="col">Group ID</th>
                        <th scope="col">Age</th>
                        <th scope="col">Created By</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td><c:out value="${student.getId()}"></c:out> </td>
                            <td><c:out value="${student.getFullName()}"></c:out> </td>
                            <td><c:out value="${student.getGroupID()}"></c:out> </td>
                            <td><c:out value="${student.getAge()}"></c:out> </td>
                            <td><c:out value="${student.getCreatedBy()}"></c:out> </td>
                            <td>
                                <a href="/student/delete/${student.getId()}" class="btn btn-danger">Delete</a> ||
                                <a href="/student/update/${student.getId()}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>

    </div>

    <h2 class="text-center my-3">Group Table</h2>

    <div class="container mt-5" >

        <div class="row">

            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Group Name</th>
                        <th scope="col">Student Count</th>
                        <th scope="col">Created By</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${groups}" var="group">
                        <tr>
                            <td><c:out value="${group.getId()}"></c:out> </td>
                            <td><c:out value="${group.getName()}"></c:out> </td>
                            <td><c:out value="${group.getStudentCount()}"></c:out> </td>
                            <td><c:out value="${group.getCreatedBy()}"></c:out> </td>
                            <td>
                                <a href="/group/delete/${group.getId()}" class="btn btn-danger">Delete</a> ||
                                <a href="/group/update/${group.getId()}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>

    </div>



    <jsp:include page="/fragments/js.jsp" ></jsp:include>

</body>
</html>
