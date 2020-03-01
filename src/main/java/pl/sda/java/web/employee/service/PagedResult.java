package pl.sda.java.web.employee.service;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class PagedResult<T> {
    private List<? extends T> result;
    private int offset;
    private int pageSize;
    private long totalCount;

    public List<Integer> getPageList(){
        List<Integer> pageList = new ArrayList<>();
        for(int i = 1; i <= totalCount/pageSize; i ++){
            pageList.add(i);
        }
        return pageList;
    }

    public int getFirstPage(){
        return 1;
    }

    public int getLastPage(){
        return (int) (totalCount/pageSize);
    }

    public List<Integer> getPreviousPages(){
        List<Integer> pages = new ArrayList<>();
        for(int i = getCurrentPage() - 5 ; i < getCurrentPage(); i++){
            if(i > 0)
                pages.add(i);
        }
        return pages;
    }

    public List<Integer> getNextPages(){
        List<Integer> pages = new ArrayList<>();
        for(int i = getCurrentPage() + 1 ; i <= getCurrentPage() + 5 ; i++){
            if(i <= getLastPage())
                pages.add(i);
        }
        return pages;
    }


    public int getCurrentPage(){
        return 1 + (offset/pageSize);
    }
}
