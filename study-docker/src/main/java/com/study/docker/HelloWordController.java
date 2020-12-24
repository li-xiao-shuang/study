package com.study.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lixiaoshuang
 * @create: 2020-12-24 15:34
 **/
@RestController
@RequestMapping(path = "api/study")
public class HelloWordController {

    @RequestMapping(path = "ok")
    public String ok() {
        return "hello world";
    }

}
