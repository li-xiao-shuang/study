package com.lxs.design.factory.service.impl;

import com.lxs.design.factory.service.Config;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 10:42
 **/
public class YamlConfig implements Config {
    @Override
    public String parseConfig() {
        return "yaml配置文件";
    }
}
