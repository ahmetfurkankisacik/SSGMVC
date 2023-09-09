<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta charset="UTF-8">
    <title>teacher-project</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
<div class="container">
    <h2>Teachers</h2>
    <table>		<tr style="background-color: #6e41b7; color:white">
        <th>ID</th>
        <th>Teacher Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Update/Delete</th>
    </tr>

        <c:forEach items="${teachers}" var="teacher" varStatus="status">

            <!-- create an "update" link with Teacher id -->
            <c:url var="updateLink" value="/teachers/update">
                <c:param name="id" value="${teacher.id}" />
            </c:url>

            <!-- create an "delete" link with Teacher id -->
            <c:url var="deleteLink" value="/teachers/delete">
                <c:param name="id" value="${teacher.id}" />
            </c:url>

            <tr
                    style="background-color:${status.index % 2==0? 'lightgray':'#9484d5'}">
                <td>${teacher.id}</td>
                <td>${teacher.teachername}</td>
                <td>${teacher.surname}</td>
                <td>${teacher.age}</td>

                <td>
                    <!-- show the links -->

                    <a class="update" href="${updateLink}">Update</a>
                    <a class="delete" href="${pageContext.request.contextPath}/teachers/delete/${teacher.id}">Delete/</a>
                    <!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
                </td>

            </tr>
        </c:forEach>
    </table>
    <p><a class="normal" href="${pageContext.request.contextPath}/teachers/form">Add Teacher</a>
</div>
</body>
</html>