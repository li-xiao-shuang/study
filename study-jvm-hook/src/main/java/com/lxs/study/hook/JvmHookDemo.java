package com.lxs.study.hook;

/**
 * @author: lixiaoshuang
 * @create: 2020-11-25 20:43
 **/
public class JvmHookDemo {

    public static void main(String[] args) throws InterruptedException {

        //自己实现的钩子
        StudyShtudownHook instance = StudyShtudownHook.getInstance();
        //将需要关闭的资源放到钩子里
        StudyResource studyResource = new StudyResource();
        instance.registerAutoCloseable(studyResource);

        //向jvm注册钩子
        Runtime.getRuntime().addShutdownHook(instance);

        System.out.println("执行业务逻辑。。。。");
        Thread.sleep(5000);
        System.out.println("业务逻辑处理完毕。。。。");
    }
}
