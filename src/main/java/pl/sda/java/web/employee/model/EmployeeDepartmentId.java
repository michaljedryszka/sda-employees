package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentId implements Serializable {

    private Employee employee;
    private Department department;
}
