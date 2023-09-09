<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page isELIgnored="false" %>
  <meta charset="UTF-8">
  <title>Add Teacher</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
<div class="container">
  <div align="center">
    <h2>Add / Update Teacher</h2>
    <table>
      <form:form modelAttribute="teacher" action="saveTeacher" method="post">
        <form:hidden path="id" />
        <tr>
          <td class="teacherprop">TeacherName:</td>
          <td><form:input path="teachername" size="30" /></td>
          <td><form:errors path="teachername" class="error" /></td>
        </tr>
        <tr>
          <td class="teacherprop">Surname:</td>
          <td><form:input path="surname" size="30" /></td>
          <td><form:errors path="surname" class="error" /></td>
        </tr>
        <tr>
          <td class="teacherprop">Age:</td>
          <td><form:input path="age" size="30" /></td>
          <td><form:errors path="age" class="error" /></td>
        </tr>
        <tr>
          <td></td>
          <td align="center"><form:button>Submit</form:button></td>
          <td></td>
        </tr>
      </form:form>
    </table>
  </div>
</div>
</body>
</html>