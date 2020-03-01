package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.service.EmployeeService;
import pl.sda.java.web.employee.service.PagedResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="employees", urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PagedResult<Employee> employees = employeeService.getEmployee(0, 100);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/jsp/employees.jsp").forward(req, resp);
    }
}
