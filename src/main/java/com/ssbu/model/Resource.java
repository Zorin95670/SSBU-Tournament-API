package com.ssbu.model;

import java.util.List;

public class Resource<T> {

    private Long total;
    private List<T> resources;

    public Resource(final Long total, final List<T> resources) {
        this.setTotal(total);
        this.setResources(resources);
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(final Long total) {
        this.total = total;
    }

    public List<T> getResources() {
        return this.resources;
    }

    public void setResources(final List<T> resources) {
        this.resources = resources;
    }
}
