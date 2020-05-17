package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "emp_no")
    private Integer empNo;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "first_name", length = 14)
    private String firstName;
    @Column(name = "last_name", length = 16)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, columnDefinition = "enum")
    private Gender gender;
    @Column(name = "hire_date")
    private LocalDate hireDate;
}
