package pl.sda.java.web.employee.service;

import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Department;
import pl.sda.java.web.employee.model.Employee;

import java.util.List;

public class EmployeeService extends AbstractExecuteOperationService {

    public PagedResult<Employee> getEmployee(int from, int to){

        Operation<PagedResult<Employee>> operation = ((session) -> {
            Query<Employee> query = session.createQuery(
                    "SELECT e from Employee e order by e.empNo", Employee.class);
            query.setFirstResult(from);
            query.setMaxResults(to);
            List<Employee> resultList = query.getResultList();

            Query countQuery = session.createQuery(
                    "SELECT count(*) from Employee");
            Long totalResult = (Long) countQuery.uniqueResult();

            return PagedResult.<Employee>builder()
                    .offset(from)
                    .pageSize(to)
                    .result(resultList)
                    .totalCount(totalResult)
                    .build();
        });
        return executeOperation(operation);
    }
}