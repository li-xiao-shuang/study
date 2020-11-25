## Shutdown hook是什么

Shutdown hook是Jvm关闭的钩子，是通过Runtime#addShutdownHook(Thread hook)方法来实现的，根据api是注解可知它就是一系例的已初始化但尚未执行的线程对象。我们可以通过向Jvm注册一个钩子，实现在程序退出时关闭资源、平滑退出的功能。所谓的优雅停机也可以这么搞。



## Jvm关闭的方式

![img](https://tva1.sinaimg.cn/large/0081Kckwly1gl1sgd4n77j30ej09v3yx.jpg)

程序只有在正常关闭和异常关闭的情况下才会调用钩子函数坐一些扫尾的工作，如果是强制关闭的则不会调用，强制关闭直接无商量终止jvm进程，不给jvm喘息的机会。

## 使用关闭钩子的注意事项

- 关闭钩子本质上是一个线程（也称为Hook线程），对于一个JVM中注册的多个关闭钩子它们将会并发执行，所以JVM并不保证它们的执行顺序；由于是并发执行的，那么很可能因为代码不当导致出现竞态条件或死锁等问题，为了避免该问题，强烈建议在一个钩子中执行一系列操作。
- Hook线程会延迟JVM的关闭时间，这就要求在编写钩子过程中必须要尽可能的减少Hook线程的执行时间，避免hook线程中出现耗时的计算、等待用户I/O等等操作。
- 关闭钩子执行过程中可能被强制打断,比如在操作系统关机时，操作系统会等待进程停止，等待超时，进程仍未停止，操作系统会强制的杀死该进程，在这类情况下，关闭钩子在执行过程中被强制中止。
- 在关闭钩子中，不能执行注册、移除钩子的操作，JVM将关闭钩子序列初始化完毕后，不允许再次添加或者移除已经存在的钩子，否则JVM抛出 IllegalStateException。
- 不能在钩子调用System.exit()，否则卡住JVM的关闭过程，但是可以调用Runtime.halt()。
- Hook线程中同样会抛出异常，对于未捕捉的异常，线程的默认异常处理器处理该异常，不会影响其他hook线程以及JVM正常退出

## 简单例子（具体可看源码）

1.业务要关闭的资源

```java
public class StudyResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("执行项目资源关闭操作");
    }
}
```

2.自定义钩子

```java
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

```

3. 向jvm注册钩子

```java
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
```

执行这段代码后输出：

> 执行业务逻辑。。。。
> 业务逻辑处理完毕。。。。
> 执行项目资源关闭操作