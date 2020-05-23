package pl.sda.java.web.employee.service;

import pl.sda.java.web.employee.model.Employee;
import pl.sda.java.web.employee.model.Title;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TitleService extends ServiceDao {

    //9999-01-01
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate maxDate = LocalDate.parse("9999-01-01", formatter);

    public void addTitle(String newTitle, Employee employee) {
        LocalDate now = LocalDate.now();
        List<Title> maxDateTitles = employee.getTitles().stream().filter(t -> t.getToDate().equals(maxDate)).collect(Collectors.toList());
        maxDateTitles.forEach(t -> {
            t.setToDate(now);
            save(t);
        });
        Title title = Title.builder()
                .title(newTitle)
                .employee(employee)
                .fromDate(now)
                .toDate(maxDate)
                .build();
        save(title);
    }
}
