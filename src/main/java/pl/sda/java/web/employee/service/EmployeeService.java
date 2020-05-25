package pl.sda.java.web.employee.service;

import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Department;
import pl.sda.java.web.employee.model.DepartmentEmployee;
import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.model.PagedResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeService extends ServiceDao {

    private int pageSize = 20;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate maxDate = LocalDate.parse("9999-01-01", formatter);

    public List<Employee> listEmployees() {
        return this.executeForList("SELECT e from Employee e", Employee.class);
    }

    public PagedResult<Employee> listEmployees(int page) {
        int offset = pageSize * (page - 1);
        return this.execute((session) -> {
            Query countQuery = session.createQuery(
                    "SELECT count(*) from Employee e ");
            Long totalCount = (Long) countQuery.uniqueResult();

            Query empQuery = session.createQuery("SELECT e from Employee e order by e.empNo ");
            empQuery.setFirstResult(offset);
            empQuery.setMaxResults(pageSize);

            return PagedResult.<Employee>builder()
                    .currentPage(page)
                    .maxPage((int) Math.ceil(totalCount / pageSize) + 1)
                    .records(empQuery.getResultList())
                    .build();

        });
    }

    public Employee getByEmployeeNumber(Integer empNo) {
        return this.execute((session) -> {
            Query<Employee> empQuery = session.createQuery("SELECT e from Employee e WHERE e.empNo=:empNo");
            empQuery.setParameter("empNo", empNo);
            return empQuery.getSingleResult();
        });
    }

    public void addEmployee(Employee employee, Department department) {
        this.execute((session) -> {
            //Zapis employee
            Query<Integer> idQuery = session.createQuery("SELECT max(e.empNo) from Employee e ");
            Integer empNo = idQuery.uniqueResult();
            empNo++;
            LocalDate now = LocalDate.now();
            employee.setHireDate(now);
            employee.setEmpNo(empNo);
            session.save(employee);
            //Przypisanie do departamentu
            DepartmentEmployee departmentEmployee = DepartmentEmployee.builder()
                    .employee(employee)
                    .department(department)
                    .fromDate(now)
                    .toDate(maxDate)
                    .build();
            session.save(departmentEmployee);
            return null;
        });
    }
}
