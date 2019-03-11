package com.ssbu.model;

import javax.ws.rs.QueryParam;

public class QueryOption {

    @QueryParam("offset")
    private int offset;

    @QueryParam("limit")
    private int limit;

    @QueryParam("order")
    private String order;

    @QueryParam("sort")
    private String sort;

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(final int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        if (this.limit == 0) {
            return 10;
        }
        return this.limit;
    }

    public void setLimit(final int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        if (this.order == null) {
            return "asc";
        }

        return this.order;
    }

    public void setOrder(final String order) {
        this.order = order;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(final String sort) {
        this.sort = sort;
    }

    public String getOrderOption(final Class<?> type) {
        if (this.getSort() == null) {
            return "";
        }

        return String.format("ORDER BY %s %s", this.getSort(), this.getOrder());
    }
}
