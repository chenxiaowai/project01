package com.itheima.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Person implements Serializable {
    private String pname;
    private Integer page;

    private List<Account>list;
    private Map<String,User>map;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pname='" + pname + '\'' +
                ", page=" + page +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
