package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employees", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", employeeService.listEmployees());
        req.getRequestDispatcher("WEB-INF/jsp/employees.jsp").forward(req, resp);
    }
}
