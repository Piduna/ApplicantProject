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
  <h1>Add/Edit subject</h1>

  <form method="post" action="controller?command=saveSubject">
    Subject name:
    <c:choose>
      <c:when test="${subject ne null}">
        <input type="text" name="subject_name" value="${subject.getSubjectName()}"/>
        <input type="hidden" name="subject_id" value="${subject.getId()}"/>
      </c:when>
      <c:otherwise>
        <input type="text" name="subject_name" value=""/>
      </c:otherwise>
    </c:choose>
    <input type=submit value=Submit>
    <a href="controller?command=subjects"><input type="button" value="Cancel"/></a>
  </form>
</div>
</body>
</html>
