package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.getByEmployeeNumber(Integer.valueOf(id));
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("WEB-INF/jsp/employee.jsp").forward(req, resp);
    }
}
