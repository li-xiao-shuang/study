package com.lxs.design.singleton;

import lombok.Data;
import lombok.Getter;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-07 17:06
 **/
public class SingletonDesign {
    public static void main(String[] args) {

        Config1 config1 = Config1.getInstance();
        System.out.println(config1.getUserName() + "-" + config1.getPassWord());

        Config2 config2 = Config2.getInstance();
        System.out.println(config2.getUserName() + "-" + config2.getPassWord());

        Config3 config3 = Config3.getInstance();
        System.out.println(config3.getUserName() + "-" + config3.getPassWord());

        Config4 config4 = Config4.getInstance();
        System.out.println(config4.getUserName() + "-" + config4.getPassWord());

        System.out.println(Config5.INSTANCE.getUserName() + "-" + Config5.INSTANCE.getPassWord());
    }
}

/**
 * 饿汉式
 */
@Data
class Config1 {

    private String userName;
    private int passWord;
    private static final Config1 INSTANCE = new Config1("config1", 123456);

    private Config1(String userName, int passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public static Config1 getInstance() {
        return INSTANCE;
    }
}

/**
 * 懒汉式，可以延迟加载
 */
@Data
class Config2 {

    private String userName;
    private int passWord;
    private static Config2 INSTANCE = null;

    private Config2(String userName, int passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public static synchronized Config2 getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Config2("config2", 123456);
        }
        return INSTANCE;
    }
}


/**
 * 双重检查
 */
@Data
class Config3 {

    private String userName;
    private int passWord;
    private static Config3 INSTANCE = null;

    private Config3(String userName, int passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public static Config3 getInstance() {
        if (null == INSTANCE) {
            synchronized (Config3.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Config3("config3", 123456);
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 静态内部类实现
 */
@Data
class Config4 {

    private String userName;
    private int passWord;
    private static Config4 INSTANCE = null;

    private Config4(String userName, int passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    private static class SingletonHolder {
        public static final Config4 INSTANCE = new Config4("config4", 123456);

    }

    public static Config4 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}

/**
 * 枚举单例
 */
enum Config5 {

    INSTANCE("config5", 123456);

    @Getter
    private String userName;
    @Getter
    private int passWord;

    Config5(String userName, int passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}




