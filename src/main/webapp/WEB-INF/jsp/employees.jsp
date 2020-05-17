<%@ include file="header.jsp" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table class="table">
  <thead class="thead-dark">
  <tr>
    <th>Number</th><th>Details</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${employees}" var = "employee">
    <tr>
      <td><c:out value = "${employee.empNo}"/></td>
      <td><c:out value = "${employee.firstName} ${employee.lastName}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%@ include file="footer.jsp" %>