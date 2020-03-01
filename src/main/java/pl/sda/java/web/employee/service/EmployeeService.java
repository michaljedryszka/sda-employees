package pl.sda.java.web.employee.service;

import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Department;
import pl.sda.java.web.employee.model.Employee;

import java.util.List;

public class EmployeeService extends AbstractExecuteOperationService<Employee> {

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

    public PagedResult<Employee> findEmployee(String searchText,
                                             int from, int to){

        Operation<PagedResult<Employee>> operation = ((session) -> {
            Query<Employee> query = session.createQuery(
                    "SELECT e from Employee e WHERE e.firstName LIKE :searchText order by e.empNo ", Employee.class);
            query.setFirstResult(from);
            query.setParameter("searchText", "%" + searchText + "%");
            query.setMaxResults(to);
            List<Employee> resultList = query.getResultList();

            Query countQuery = session.createQuery(
                    "SELECT count(*) from Employee e WHERE e.firstName LIKE :searchText");
            countQuery.setParameter("searchText", "%" + searchText + "%");
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

    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        System.out.println(es.findEmployee("a", 0, 100).getResult().size());
    }
}