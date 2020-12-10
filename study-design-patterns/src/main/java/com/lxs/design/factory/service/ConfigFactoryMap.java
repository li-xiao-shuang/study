package com.lxs.design.factory.service;

import com.lxs.design.factory.service.impl.JsonConfigParseFactory;
import com.lxs.design.factory.service.impl.XmlConfigParseFactory;
import com.lxs.design.factory.service.impl.YamlConfigParseFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-10 11:46
 **/
public class ConfigFactoryMap {

    private static Map<String, ConfigParseFactory> CONFIG_PARSE_FACTORY_MAP = new HashMap<>();
    public static final String JSON = "json";
    private static final String XML = "xml";
    private static final String YAML = "yaml";


    static {
        CONFIG_PARSE_FACTORY_MAP.put(JSON, new JsonConfigParseFactory());
        CONFIG_PARSE_FACTORY_MAP.put(XML, new XmlConfigParseFactory());
        CONFIG_PARSE_FACTORY_MAP.put(YAML, new YamlConfigParseFactory());
    }

    public static ConfigParseFactory getConfigFactory(String suffix) {
        if (suffix == null) {
            return null;
        }
        return CONFIG_PARSE_FACTORY_MAP.get(suffix);
    }

}
