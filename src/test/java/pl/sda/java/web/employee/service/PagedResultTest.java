package pl.sda.java.web.employee.service;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PagedResultTest {

    private PagedResult pagedResult;

    @Before
    public void setUp(){
        pagedResult = PagedResult.builder()
                .pageSize(100)
                .totalCount(10000)
                .build();
    }

    @Test
    public void getFirstPage() {
    }

    @Test
    public void getLastPage() {
    }

    @Test
    public void getPreviousPagesForOffsetZero() {
        pagedResult.setOffset(0);

        assertTrue(pagedResult.getPreviousPages().isEmpty());
    }

    @Test
    public void getPreviousPagesForOffsetTwoHundere() {
        pagedResult.setOffset(200);

        assertEquals(Arrays.asList(1,2),
                pagedResult.getPreviousPages());
    }

    @Test
    public void getPreviousPagesForOffsetFiveHundred() {
        pagedResult.setOffset(500);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5),
                pagedResult.getPreviousPages());
    }

    @Test
    public void getPreviousPagesForOffsetOneThousand() {
        pagedResult.setOffset(1000);

        assertEquals(Arrays.asList(6, 7, 8, 9, 10),
                pagedResult.getPreviousPages());
    }

    @Test
    public void getNextPagesForOffsetZero() {
        pagedResult.setOffset(0);

        assertEquals(Arrays.asList(2, 3, 4, 5, 6),
                pagedResult.getNextPages());
    }

    @Test
    public void getNextPagesForOffsetTotalCount() {
        pagedResult.setOffset(9999);

        assertEquals(Arrays.asList(),
                pagedResult.getNextPages());
    }

    @Test
    public void getNextPagesForBeforeLastPage() {
        pagedResult.setOffset(9899);

        assertEquals(Arrays.asList(100),
                pagedResult.getNextPages());
    }


    @Test
    public void getCurrentPage1() {
        pagedResult.setOffset(0);

        assertEquals(1, pagedResult.getCurrentPage());
    }

    @Test
    public void getCurrentPage5() {
        pagedResult.setOffset(500);

        assertEquals(6, pagedResult.getCurrentPage());
    }

    @Test
    public void getCurrentPage10() {
        pagedResult.setOffset(999);

        assertEquals(10, pagedResult.getCurrentPage());
    }

}