<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form>
<input name="searchText" value="${sessionSearchText}"/>
<input type="submit" value="Search"/>
</form>
Employees:
<a href="?page=${employees.firstPage}">${employees.firstPage}</a>
<a href="?page=${employees.currentPage - 5}">...</a>
<c:forEach items="${employees.previousPages}" var="page">
    <a href="?page=${page}">${page}</a>
</c:forEach>
<b>${employees.currentPage}</b>
<c:forEach items="${employees.nextPages}" var="page">
    <a href="?page=${page}">${page}</a>
</c:forEach>
<a href="?page=${employees.currentPage + 5}">...</a>
<a href="?page=${employees.lastPage}">${employees.lastPage}</a>


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
    <td><c:out value="${emp.firstName}"/> <c:out value="${emp.lastName}"/></td>
    <td><c:out value="${emp.gender}"/></td>
    <td>
        <c:forEach items="${emp.employeeDepartments}" var="empDept">
            ${empDept.department.deptName}
        </c:forEach>
    </td>
</tr>
</c:forEach>
</table>