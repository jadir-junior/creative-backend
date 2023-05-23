package com.jj.creative.utils.pagination;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class ResponsePagination<T> {
    private List<T> data;
    private Pagination<T> pagination;

    public ResponsePagination(Page<T> page) {
        this.data = page.getContent();
        this.pagination = new Pagination<>(page);
    }

}
