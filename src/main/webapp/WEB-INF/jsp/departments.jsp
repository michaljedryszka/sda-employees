<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form method="POST">
    Nr: <input name="deptNo" value="${department.deptNo}"/><br/>
    Name: <input name="deptName" value="${department.deptName}"/><br/>
    <input type="submit" value="Save"/>
</form>
Departments:
<c:forEach items="${departments}" var = "dep">
    <p><a href="?deptNo=${dep.deptNo}"><c:out value = "${dep.deptNo}"/></a> <c:out value = "${dep.deptName}"/></p>
</c:forEach>
