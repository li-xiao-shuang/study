package com.lxs.study.hook;

/**
 * @author: lixiaoshuang
 * @create: 2020-11-25 21:05
 **/
public class StudyResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("执行项目资源关闭操作");
    }
}
