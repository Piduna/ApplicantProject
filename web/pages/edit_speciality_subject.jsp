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

<html>
<head>
  <title></title>
</head>
<body>
<div class = "all">
  <h1>Add/Edit speciality subject</h1>

  <form method="post" action="controller?command=saveSpeciality">

    <c:choose>
      <c:when test="${speciality ne null}">
        <p>Profession name: <select name="profession_name">
          <c:forEach items="${professions}" var="profession">
            <option value="${profession.getId()}">
              <c:out value="${profession.getProfessionName()}"></c:out>
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
        <input type="hidden" name="sp_sb_id" value="${speciality.getId()}"/>
      </c:when>
      <c:otherwise>
        <p>Profession name: <select name="profession_name">
          <c:forEach items="${professions}" var="profession">
            <option value="${profession.getId()}">
              <c:out value="${profession.getProfessionName()}"></c:out>
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
      </c:otherwise>
    </c:choose>
    <input type=submit value=Submit>
    <a href="controller?command=specialitys"><input type="button" value="Cancel"/></a>
  </form>
</div>
</body>
</html>
