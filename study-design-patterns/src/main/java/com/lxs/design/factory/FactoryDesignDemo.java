package com.lxs.design.factory;

import com.lxs.design.factory.service.Config;
import com.lxs.design.factory.service.ConfigFactoryMap;
import com.lxs.design.factory.service.impl.JsonConfig;
import com.lxs.design.factory.service.impl.XmlConfig;
import com.lxs.design.factory.service.impl.YamlConfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoryDesignDemo {


    public static void main(String[] args) throws Exception {
        //正常业务代码、if else流程
        String fileName = "lxs.xml";
        var config = parseFile(fileName);
        System.out.println(config.parseConfig());


        //工厂设计模式改造
        String file = "lxs@.json";
        List<String> splitList = Stream.of(file.split("@.")).collect(Collectors.toList());
        String suffix = splitList.get(splitList.size() - 1);

        Config config1 = ConfigFactoryMap.getConfigFactory(suffix).createConfig();
        String result = config1.parseConfig();
        System.out.println(result);
    }

    private static Config parseFile(String fileName) throws Exception {
        if (fileName.endsWith(".json")) {
            return new JsonConfig();
        } else if (fileName.endsWith(".xml")) {
            return new XmlConfig();
        } else if (fileName.endsWith(".yaml")) {
            return new YamlConfig();
        }
        throw new Exception("异常文件格式");
    }
}
