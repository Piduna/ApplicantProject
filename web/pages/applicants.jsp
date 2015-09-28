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
  <c:choose>
  <c:when test="${applicants.size() == 0}">
  <p><c:out value="No applicants yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
    <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Profession ID</th>
    <th>Entrance Year</th>
    </tr>
    <c:forEach items="${applicants}" var="applicant">
    <tr>
      <td>
          <c:out value="${applicant.getId()}"/>
          </td>
          <td>
          <c:out value="${applicant.getFirstName()}"/>
          </td>
          <td>
          <c:out value="${applicant.getLastName()}"/>
          </td>
          <td>
          <c:out value="${applicant.getProfessionName()}"/>
          </td>
          <td>
          <c:out value="${applicant.getEntranceYear()}"/>
          </td>
            <td class ="actions"><a href="controller?command=deleteApplicant&id=${applicant.getId()}" class="delete">Delete</a></td>
            <script type="text/javascript">
                var elems = document.getElementsByClassName('delete');
                var confirmIt = function (e) {
                    if (!confirm('Are you sure to delete?')) e.preventDefault();
                };
                for (var i = 0, l = elems.length; i < l; i++) {
                    elems[i].addEventListener('click', confirmIt, false);
                }
            </script>
            <td class ="actions2"><a href="controller?command=editApplicant&id=${applicant.getId()}">Edit</a></td>
          </tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>
  <div class = "add">
    <a href="controller?command=addApplicant">Add new applicant</a>
  </div>
</div>
</body>
</html>