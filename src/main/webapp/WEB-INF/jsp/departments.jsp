<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form>
    
</form>
Departments:
<c:forEach items="${departments}" var = "dep">
    <p><c:out value = "${dep.deptNo}"/> <c:out value = "${dep.deptName}"/></p>
</c:forEach>
