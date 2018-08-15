package com.ssmp.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;

    private String permisson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermisson() {
        return permisson;
    }

    public void setPermisson(String permisson) {
        this.permisson = permisson == null ? null : permisson.trim();
    }
}