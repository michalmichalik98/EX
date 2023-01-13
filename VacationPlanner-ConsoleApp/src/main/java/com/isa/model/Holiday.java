package com.isa.model;

import java.util.Date;

class Holiday {
    private String name;
    private Date startDate;
    private Date endDate;

    public Holiday(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
