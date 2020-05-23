package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.service.EmployeeService;
import pl.sda.java.web.employee.service.TitleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name="removetitle", urlPatterns = "/removetitle")
public class RemoveTitleServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    private TitleService titleService = new TitleService();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String fromDate = req.getParameter("fromDate");

        Employee employee = employeeService.getByEmployeeNumber(Integer.valueOf(id));
        titleService.removeTitle(title, employee, LocalDate.parse(fromDate, formatter));
        resp.sendRedirect("employee?id=" + id);
    }
}
