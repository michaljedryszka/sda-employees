package pl.sda.java.web.employee.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PagedResult<T> {
    private int currentPage;
    private int maxPage;
    private List<T> records;
}
