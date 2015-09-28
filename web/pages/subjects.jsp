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
<c:if test="${subjects.size() == 0}">
No subjects
  </c:if>
  <table>
    <tr>
      <th>ID</th>
      <th>Subject Name</th>
    </tr>
    <c:forEach items="${subjects}" var="subject">
      <tr>
        <td><c:out value="${subject.getId()}"/></td>
        <td><c:out value="${subject.getSubjectName()}"/></td>
        <td class ="actions"><a href="controller?command=deleteSubject&id=${subject.getId()}" class="delete">Delete</a></td>
        <script type="text/javascript">
          var elems = document.getElementsByClassName('delete');
          var confirmIt = function (e) {
            if (!confirm('Are you sure to delete?')) e.preventDefault();
          };
          for (var i = 0, l = elems.length; i < l; i++) {
            elems[i].addEventListener('click', confirmIt, false);
          }
        </script>
        <td class ="actions2"><a href="controller?command=editSubject&id=${subject.getId()}">Edit</a></td>
        </td>
      </tr>
    </c:forEach>
  </table>
  <div class = "add">
    <a href="controller?command=addSubject">Add subject</a>
  </div>
</div>
</body>
</html>

