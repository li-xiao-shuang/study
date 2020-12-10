package com.lxs.design.factory.service.impl;

import com.lxs.design.factory.service.Config;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 10:41
 **/
public class XmlConfig implements Config {
    @Override
    public String parseConfig() {
        return "xml配置文件";
    }
}
