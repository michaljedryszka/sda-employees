package pl.sda.java.web.employee.service;

import pl.sda.java.web.employee.model.Employee;

import java.util.List;

public class EmployeeService extends ServiceDao{

    public List<Employee> listEmployees(){
        return this.executeForList("SELECT e from Employee e", Employee.class);
    }
}
