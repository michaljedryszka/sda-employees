package pl.sda.java.web.employee.service;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PagedResult<T> {
    private List<? extends T> result;
    private int offset;
    private int pageSize;
    private long totalCount;
}
