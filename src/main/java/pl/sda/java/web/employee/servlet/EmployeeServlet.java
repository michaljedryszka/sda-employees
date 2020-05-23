package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.model.Gender;
import pl.sda.java.web.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "employee", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.getByEmployeeNumber(Integer.valueOf(id));
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("WEB-INF/jsp/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.getByEmployeeNumber(Integer.valueOf(id));
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));

        String gender = req.getParameter("gender");
        employee.setGender(Gender.valueOf(gender));

        LocalDate birthDate = getDate(req.getParameter("birthDate"));
        employee.setBirthDate(birthDate);

        employee.setHireDate(getDate(req.getParameter("hireDate")));

        employeeService.save(employee);
        //after post redirect
        resp.sendRedirect("employee?id=" + id);
    }

    private LocalDate getDate(String date) {
        return LocalDate.parse(date, formatter);
    }
}
