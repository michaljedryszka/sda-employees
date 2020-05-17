package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="titles")
@IdClass(TitleId.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    @Id
    @OneToOne
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @Id
    @Column(length = 50)
    private String title;

    @Id
    @Column(name="from_date")
    private LocalDate fromDate;

    @Column(name="to_date")
    private LocalDate toDate;
}
