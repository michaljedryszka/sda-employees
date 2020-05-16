<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table>
  <tr>
    <td>Dept number</td><td>Dept name</td>
  </tr>
  <c:forEach items="${departments}" var = "department">
    <tr>
      <td><c:out value = "${department.deptNo}"/></td>
      <td><c:out value = "${department.deptName}"/></td>
    </tr>
  </c:forEach>
</table>