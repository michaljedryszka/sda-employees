<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
Employees: ${employees.firstPage} ... ${employees.previousPages} ${employees.currentPage} ${employees.nextPages} ... ${employees.lastPage}
<%--
1 ... <a href="">95</a> <a href="">96</a> <a href=""> 97</a> <a href=""> 98</a> <a href=""> 99</a> <a href=""></a> <b>100</b> <a href="">101</a> <a href=""> 102</a> <a href=""> 103</a> <a href=""> 104</a> <a href=""> 105</a>... <a href="">9999</a>
<c:forEach items="${employees.pageList}" var="page">
    ${page}
</c:forEach>
--%>
<table>
<c:forEach items="${employees.result}" var="emp">
<tr>
    <td><c:out value="${emp.empNo}"/></td>
    <td><c:out value="${emp.firstName}"/><c:out value="${emp.lastName}"/></td>
    <td><c:out value="${emp.gender}"/></td>
</tr>
</c:forEach>
</table>