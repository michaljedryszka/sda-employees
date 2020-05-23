package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "employee")
//    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinColumn(name = "emp_no")
    private List<DepartmentEmployee> departmentEmployee;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "employee")
//    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinColumn(name = "emp_no")
    private List<Title> titles;

    public Title getActiveTitle() {
        Date now = new Date();
        Title title = titles.stream().filter(t -> {
            long fromDate = t.getFromDate().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
            long toDate = t.getToDate().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
            if (fromDate < now.getTime() && (now.getTime() < toDate || t.getToDate() == null)) {
                return true;
            }
            return false;
        }).findFirst().orElseGet(Title::new);
        return title;
    }
}
