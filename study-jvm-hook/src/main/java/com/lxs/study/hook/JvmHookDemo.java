package com.lxs.study.hook;

/**
 * @author: lixiaoshuang
 * @create: 2020-11-25 20:43
 **/
public class JvmHookDemo {

    public static void main(String[] args) throws InterruptedException {

        StudyShtudownHook instance = StudyShtudownHook.getInstance();

        StudyResource studyResource = new StudyResource();
        instance.registerAutoCloseable(studyResource);

        //先注册钩子
        Runtime.getRuntime().addShutdownHook(instance);

        System.out.println("执行业务逻辑。。。。");
        Thread.sleep(5000);
        System.out.println("业务逻辑处理完毕。。。。");
    }
}
