package pl.sda.java.web.employee.servlet;


import pl.sda.java.web.employee.model.Department;
import pl.sda.java.web.employee.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name="departments", urlPatterns="/departments")
public class DepartmentsServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull(req.getParameter("deptNo"))){
            Department department =
                    departmentService.find(req.getParameter("deptNo"));
            req.setAttribute("department", department);
        }
        List<Department> departments = departmentService.getAllDepartments();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/WEB-INF/jsp/departments.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = departmentService.find(req.getParameter("deptNo"));
        if(Objects.nonNull(department)){
            department.setDeptName(req.getParameter("deptName"));
        }else{
            department = Department.builder()
                    .deptNo(req.getParameter("deptNo"))
                    .deptName(req.getParameter("deptName"))
                    .build();
        }
        departmentService.save(department);
        resp.sendRedirect("/employee/departments");
    }
}
