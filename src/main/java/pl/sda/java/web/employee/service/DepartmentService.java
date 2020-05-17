package pl.sda.java.web.employee.service;

import pl.sda.java.web.employee.model.Department;

import java.util.List;

public class DepartmentService extends ServiceDao{

    public List<Department> listDepartments(){
        return this.executeForList("SELECT d from Department d", Department.class);
    }
}
