package pl.sda.java.web.employee.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class TitleId implements Serializable {
    private Employee employee;
    private String title;
    private LocalDate fromDate;
}
