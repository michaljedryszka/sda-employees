package pl.sda.java.web.employee.service;

import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Department;

import java.util.List;

public class DepartmentService extends ServiceDao{

    public List<Department> listDepartments(){
        return this.executeForList("SELECT d from Department d", Department.class);
    }

    public Department getByDepNo(String deptNo){
        return this.execute((session) -> {
            Query<Department> empQuery = session.createQuery("SELECT d from Department d WHERE d.deptNo=:deptNo");
            empQuery.setParameter("deptNo", deptNo);
            return empQuery.getSingleResult();
        });
    }
}
