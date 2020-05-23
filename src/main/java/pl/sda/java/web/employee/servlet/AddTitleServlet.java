package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.model.Title;
import pl.sda.java.web.employee.service.EmployeeService;
import pl.sda.java.web.employee.service.TitleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addtitle", urlPatterns = "/addtitle")
public class AddTitleServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    private TitleService titleService = new TitleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String newTitle = req.getParameter("newTitle");
        Employee employee = employeeService.getByEmployeeNumber(Integer.valueOf(id));
        titleService.addTitle(newTitle, employee);
        resp.sendRedirect("employee?id=" + id);
    }
}
