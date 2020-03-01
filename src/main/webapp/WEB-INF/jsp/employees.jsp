<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
Employees:
<table>
<c:forEach items="${employees.result}" var="emp">
<tr>
    <td><c:out value="${emp.empNo}"/></td>
    <td><c:out value="${emp.firstName}"/><c:out value="${emp.lastName}"/></td>
    <td><c:out value="${emp.gender}"/></td>
</tr>
</c:forEach>
</table>