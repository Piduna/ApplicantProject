<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title></title>
<link media="all" rel="stylesheet" href="css/all.css" />
</head>
<body>
<div class="header">
  <h2><a class="header-link" href="/app">Main Dashboard</a></h2>
</div>
<div class="menu">
  <ul>
    <li><a href="controller?command=applicants">Applicants</a></li>
    <li><a href="controller?command=professions">Professions</a></li>
    <li><a href="controller?command=subjects">Subjects</a></li>
    <li><a href="controller?command=specialitys">Speciality subjects</a></li>
    <li><a href="controller?command=results">Applicants results</a></li>
  </ul>
</div>

<div class = "all">
  <h1>Add/Edit applicant result</h1>

  <form method="post" action="controller?command=saveResult">

    <c:choose>
      <c:when test="${result ne null}">
        <p>Last name: <select name="last_name">
          <c:forEach items="${applicants}" var="applicant">
            <option value="${applicant.getId()}">
              <c:out value="${applicant.getLastName()}"></c:out>
            </option>
          </c:forEach>
        </select></p>
        <p>Subject name: <select name="subject_name">
          <c:forEach items="${subjects}" var="subject">
            <option value="${subject.getId()}">
              <c:out value="${subject.getSubjectName()}"></c:out>
            </option>
          </c:forEach>
        </select></p>
        </p>Mark: <input type="text" name="mark" value="${result.getMark()}"/></p>
        <input type="hidden" name="applicant_result_id" value="${result.getId()}"/>
      </c:when>
      <c:otherwise>
        <p>Last name: <select name="last_name">
          <c:forEach items="${applicants}" var="applicant">
            <option value="${applicant.getId()}">
              <c:out value="${applicant.getLastName()}"></c:out>
            </option>
          </c:forEach>
        </select></p>
        <p>Subject name: <select name="subject_name">
          <c:forEach items="${subjects}" var="subject">
            <option value="${subject.getId()}">
              <c:out value="${subject.getSubjectName()}"></c:out>
            </option>
          </c:forEach>
        </select></p>
        </p>Mark: <input type="text" name="mark" value=""/></p>
      </c:otherwise>
    </c:choose>
    <input type=submit value=Submit>
    <a href="controller?command=results"><input type="button" value="Cancel"/></a>
  </form>
</div>
</body>
</html>

