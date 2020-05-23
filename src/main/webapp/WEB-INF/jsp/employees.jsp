<%@ include file="header.jsp" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table class="table">
  <thead class="thead-dark">
  <tr>
    <th>Number</th><th>Details</th>
  </tr>
  <tr>
    <th colspan="2">
      <c:set var="initialPage" value="1"/>
      <c:if test = "${employees.currentPage - 5 > 0}">
        <c:set var="initialPage" value="${employees.currentPage - 5}"/>
      </c:if>
      <c:forEach var = "i" begin = "${initialPage}" end = "${employees.currentPage - 1}">
         <a href="?showPage=${i}">${i}</a>
      </c:forEach>
        Page ${employees.currentPage}
      <c:forEach var = "i" begin = "${employees.currentPage + 1}" end = "${employees.currentPage + 5}">
         <a href="?showPage=${i}">${i}</a>
      </c:forEach>
    </th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${employees.records}" var = "employee">
    <tr>
      <td><a href="employee?id=<c:out value = "${employee.empNo}"/>"><c:out value = "${employee.empNo}"/></a></td>
      <td><c:out value = "${employee.activeTitle.title} ${employee.firstName} ${employee.lastName} ${employee.departmentEmployee[0].department.deptName}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%@ include file="footer.jsp" %>