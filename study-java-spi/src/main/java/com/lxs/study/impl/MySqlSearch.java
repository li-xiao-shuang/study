package com.lxs.study.impl;

import com.lxs.study.biz.SearchDemo;

public class MySqlSearch implements SearchDemo {
    @Override
    public void search(String name) {
        System.out.println("mysql 搜索: " + name);
    }
}
