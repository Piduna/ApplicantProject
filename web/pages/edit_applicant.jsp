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
  <h1>Add/Edit applicant</h1>

  <form method="post" action="controller?command=saveApplicant">

    <c:choose>
      <c:when test="${applicant ne null}">
        <p>First Name: <input type="text" name="first_name" value="${applicant.getFirstName()}"/></p>
        <p>Last Name: <input type="text" name="last_name" value="${applicant.getLastName()}"/></p>
        <p>Profession: <select name="profession_name">
          <c:forEach items="${professions}" var="profession">
            <option value="${profession.getId()}">
              <c:out value="${profession.getProfessionName()}"></c:out>
            </option>
          </c:forEach>
        </select>
        </p>
        <p>Entrance Year: <input type="text" name="entrance_year" value="${applicant.getEntranceYear()}"/></p>
        <input type="hidden" name="applicant_id" value="${applicant.getId()}"/>
      </c:when>
      <c:otherwise>
      <p>First Name: <input type="text" name="first_name" value=""/></p>
      <p>Last Name: <input type="text" name="last_name" value=""/></p>
      <p>Profession: <select name="profession_name">
          <c:forEach items="${professions}" var="profession">
            <option value="${profession.getId()}">
              <c:out value="${profession.getProfessionName()}"></c:out>
            </option>
          </c:forEach>
        </select></p>
      <p>Entrance Year: <input type="text" name="entrance_year" value=""/></p>
      </c:otherwise>
    </c:choose>
    <input type=submit value=Submit>
    <a href="controller?command=applicants"><input type="button" value="Cancel"/></a>
  </form>
</div>
</body>
</html>

