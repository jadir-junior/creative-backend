package com.jj.creative.utils.pagination;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class ResponsePagination<D, E> {
    private List<D> data;
    private Pagination<E> pagination;

    public ResponsePagination(List<D> dto, Page<E> page) {
        this.data = dto;
        this.pagination = new Pagination<E>(page);
    }

}
