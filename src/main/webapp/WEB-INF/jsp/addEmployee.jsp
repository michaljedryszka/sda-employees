<%@ include file="header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

 <div class="card">
 <div class="card-body">
 <form method="POST">
     <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">First
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="firstName"
        placeholder="Enter first name" value="<c:out value = "${employee.firstName}" />"/>
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Last
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="lastName"
        placeholder="Enter last name" value="<c:out value = "${employee.lastName}" />"/>
      </div>
     </div>

     <div class="form-group row">
      <label for="birthDate" class="col-sm-2 col-form-label">Birth date</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="birthDate"
        placeholder="Enter birth date" value="<c:out value = "${employee.birthDate}" />"/>
      </div>
     </div>

     <div class="form-group row">
      <label for="gender" class="col-sm-2 col-form-label">Gender</label>
      <div class="col-sm-7">
       <select name="gender" class="form-control">
        <option id="F" <c:if test="${employee.gender == 'F'}">selected</c:if> >F</option>
        <option id="M" <c:if test="${employee.gender == 'M'}">selected</c:if> >M</option>
       </select>
      </div>
     </div>

     <div class="form-group row">
      <label for="hireDate" class="col-sm-2 col-form-label">Department</label>
      <div class="col-sm-7">
       <select class="form-control" name="department">
        <c:forEach items="${departments}" var = "department">
         <option value="<c:out value = "${department.deptNo}" />"><c:out value = "${department.deptName}" /></option>
        </c:forEach>
       </select>
      </div>
     </div>
  <button type="submit" class="btn btn-primary">Submit</button>
 </form>
 </div>
 </div>

<%@ include file="footer.jsp" %>