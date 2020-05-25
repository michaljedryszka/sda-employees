<%@ include file="header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

 <div class="card">
 <div class="card-body">
 <form method="POST">
    <input type="hidden" name="id" value="<c:out value = "${employee.empNo}"/>" />
     <div class="form-group row">
      <label for="empNo" class="col-sm-2 col-form-label">Emp no.</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="empNo" disabled="true" value="<c:out value = "${employee.empNo}" />"/>
      </div>
     </div>

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
      <label for="hireDate" class="col-sm-2 col-form-label">Hire date</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="hireDate"
        placeholder="Enter hire date" value="<c:out value = "${employee.hireDate}" />"/ >
      </div>
     </div>
  <button type="submit" class="btn btn-primary">Submit</button>
 </form>
 <hr/>
 <p>Departments</p>
 <table class="table">
   <thead class="thead-dark">
   <tr>
     <th>Dept number</th><th>Dept name</th><th>From date</th><th>To date</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${employee.departmentEmployee}" var = "departmentEmployee">
     <tr>
       <td><c:out value = "${departmentEmployee.department.deptNo}"/></td>
       <td><c:out value = "${departmentEmployee.department.deptName}"/></td>
       <td><c:out value = "${departmentEmployee.fromDate}"/></td>
       <td><c:out value = "${departmentEmployee.toDate}"/></td>
     </tr>
   </c:forEach>
   </tbody>
 </table>
 <hr/>
 <p>Titles</p>
 <table class="table">
   <thead class="thead-dark">
   <tr>
     <th>Title</th><th>From date</th><th>To date</th><th></th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${employee.titles}" var = "title">
     <tr>
       <td><c:out value = "${title.title}"/></td>
       <td><c:out value = "${title.fromDate}"/></td>
       <td><c:out value = "${title.toDate}"/></td>
       <td>
           <form method="POST" action="removetitle">
               <button type="submit" class="btn btn-primary">X</button>
               <input type="hidden" name="id" value="<c:out value = "${employee.empNo}"/>" />
               <input type="hidden" name="title" value="<c:out value = "${title.title}"/>" />
               <input type="hidden" name="fromDate" value="<c:out value = "${title.fromDate}"/>" />
           </form>
       </td>
     </tr>
   </c:forEach>
     <tr>
       <form method="POST" action="addtitle">
           <td><input type="text" name="newTitle"/> <button type="submit" class="btn btn-primary">Add</button></td>
           <input type="hidden" name="id" value="<c:out value = "${employee.empNo}"/>" />
       </form>
       <td></td>
       <td></td>
     </tr>
   </tbody>
 </table>

 </div>
 </div>

<%@ include file="footer.jsp" %>