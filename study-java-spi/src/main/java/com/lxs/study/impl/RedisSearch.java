package com.lxs.study.impl;

import com.lxs.study.biz.SearchDemo;

public class RedisSearch implements SearchDemo {
    @Override
    public void search(String name) {
        System.out.println("reids 搜索: " + name);
    }
}
