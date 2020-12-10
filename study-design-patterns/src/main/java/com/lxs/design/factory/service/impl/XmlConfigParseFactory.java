package com.lxs.design.factory.service.impl;

import com.lxs.design.factory.service.Config;
import com.lxs.design.factory.service.ConfigParseFactory;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 11:14
 **/
public class XmlConfigParseFactory implements ConfigParseFactory {
    @Override
    public Config createConfig() {
        return new XmlConfig();
    }
}
