package pl.sda.java.web.employee.servlet;

import pl.sda.java.web.employee.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="departments", urlPatterns = "/departments")
public class DepartmentServlet extends HttpServlet {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pobrac liste departamentow
        req.setAttribute("departments", departmentService.listDepartments());
        req.getRequestDispatcher("WEB-INF/jsp/departments.jsp").forward(req, resp);
    }
}
