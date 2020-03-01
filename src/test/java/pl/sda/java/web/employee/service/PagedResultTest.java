package pl.sda.java.web.employee.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PagedResultTest {

    private PagedResult pagedResult;

    @Before
    public void setUp(){
        pagedResult = PagedResult.builder().build();
    }

    @Test
    public void getFirstPage() {
    }

    @Test
    public void getLastPage() {
    }

    @Test
    public void getPreviousPages() {
    }

    @Test
    public void getCurrentPage1() {
        pagedResult.setOffset(0);
        pagedResult.setPageSize(100);
        pagedResult.setTotalCount(10000);

        assertEquals(1, pagedResult.getCurrentPage());
    }

    @Test
    public void getCurrentPage5() {
        pagedResult.setOffset(500);
        pagedResult.setPageSize(100);
        pagedResult.setTotalCount(10000);

        assertEquals(6, pagedResult.getCurrentPage());
    }

    @Test
    public void getCurrentPage10() {
        pagedResult.setOffset(999);
        pagedResult.setPageSize(100);
        pagedResult.setTotalCount(10000);

        assertEquals(10, pagedResult.getCurrentPage());
    }

}