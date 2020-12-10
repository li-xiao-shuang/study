package com.lxs.design.factory.service.impl;

import com.lxs.design.factory.service.Config;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 10:40
 **/
public class JsonConfig implements Config {

    @Override
    public String parseConfig() {
        return "json配置文件";
    }
}
