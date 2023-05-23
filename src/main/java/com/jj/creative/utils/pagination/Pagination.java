package com.jj.creative.utils.pagination;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class Pagination<T> {
    private Integer currentPage;
    private Integer itemsPerPage;
    private long totalItens;
    private Integer totalPages;

    Pagination(Page<T> page) {
        this.currentPage = page.getNumber();
        this.totalItens = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.itemsPerPage = page.getSize();
    }
}
