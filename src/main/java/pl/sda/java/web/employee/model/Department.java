package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @Column(name="dept_no", length = 4, columnDefinition = "CHAR(4)")
    private String deptNo;

    @Column(name="dept_name", length = 40)
    private String deptName;
}
