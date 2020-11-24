package com.lxs.study;

import com.lxs.study.biz.SearchDemo;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class LoadSearch {
    public static void main(String[] args) {
        ServiceLoader<SearchDemo> load = ServiceLoader.load(SearchDemo.class);
        List<SearchDemo> searchDemos = load.stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());

        for (SearchDemo searchDemo : searchDemos) {
            searchDemo.search("lxs");
        }
    }
}
