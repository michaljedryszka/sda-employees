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
import java.util.Objects;

@WebServlet(name = "employees", urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

    public static final int PAGE_SIZE = 100;

    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        int offset = 0;
        if (Objects.nonNull(page)) {
            offset = (Integer.valueOf(page) - 1) * PAGE_SIZE;
        }
        PagedResult<Employee> employees;
        if (Objects.nonNull(req.getParameter("searchText"))) {
            employees = employeeService.findEmployee(req.getParameter("searchText"), offset, PAGE_SIZE);
        } else {
            employees = employeeService.getEmployee(offset, PAGE_SIZE);
        }
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/jsp/employees.jsp").forward(req, resp);
    }
}
