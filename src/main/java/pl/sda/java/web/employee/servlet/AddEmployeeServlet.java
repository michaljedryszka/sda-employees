package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Department;
import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.model.Gender;
import pl.sda.java.web.employee.service.DepartmentService;
import pl.sda.java.web.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "addEmployee", urlPatterns = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    private EmployeeService employeeService = new EmployeeService();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", departmentService.listDepartments());
        req.getRequestDispatcher("WEB-INF/jsp/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        String gender = req.getParameter("gender");
        employee.setGender(Gender.valueOf(gender));
        LocalDate birthDate = getDate(req.getParameter("birthDate"));
        employee.setBirthDate(birthDate);

        Department department = departmentService.getByDepNo(req.getParameter("department"));

        employeeService.addEmployee(employee, department);

        resp.sendRedirect("employee?id=" + employee.getEmpNo());
    }

    private LocalDate getDate(String date) {
        return LocalDate.parse(date, formatter);
    }
}
