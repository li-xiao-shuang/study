package com.lxs.study.hook;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lixiaoshuang
 * @create: 2020-11-25 20:48
 **/
public class StudyShtudownHook extends Thread {

    private static final StudyShtudownHook INSTANCE = new StudyShtudownHook();
    /**
     * 需要关闭的钩子集合,可以将项目中的资源关闭操作都放在这里
     */
    private final Set<AutoCloseable> autoCloseableHashSet = new HashSet<>();


    private StudyShtudownHook() {

    }

    public static StudyShtudownHook getInstance() {
        return INSTANCE;
    }


    public void registerAutoCloseable(final AutoCloseable autoCloseable) {
        autoCloseableHashSet.add(autoCloseable);
    }

    @Override
    public void run() {
        this.closeAll();
    }

    @SneakyThrows
    private void closeAll() {
        for (AutoCloseable autoCloseable : autoCloseableHashSet) {
            autoCloseable.close();
        }
    }
}
