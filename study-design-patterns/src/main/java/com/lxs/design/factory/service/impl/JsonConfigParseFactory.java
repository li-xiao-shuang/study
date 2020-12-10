package com.lxs.design.factory.service.impl;

import com.lxs.design.factory.service.Config;
import com.lxs.design.factory.service.ConfigParseFactory;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 11:12
 **/
public class JsonConfigParseFactory implements ConfigParseFactory {
    @Override
    public Config createConfig() {
        return new JsonConfig();
    }
}
