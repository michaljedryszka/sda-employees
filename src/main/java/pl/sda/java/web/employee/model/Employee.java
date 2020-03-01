package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    public enum Gender {M, F}

    @Id
    @Column(name="emp_no")
    private int empNo;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="first_name", length = 14)
    private String firstName;

    @Column(name="last_name", length = 16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, columnDefinition = "enum")
    private Gender gender;

    @Column(name="hire_date")
    private LocalDate hireDate;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<EmployeeDepartment> employeeDepartments;
}
