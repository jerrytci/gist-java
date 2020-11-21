package com.rejerry.javagist.web;

import com.rejerry.javagist.web.request.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/up21")
public class UP21Controller {

    @RequestMapping("/hello")
    public String index() {
        return "hello word";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(@RequestBody Person query) {
        String textBlocks = "{\"registry-mirrors\":[\"https://qwaohyv6.mirror.aliyuncs.com\",\"https://hub-mirror.c.163.com/\",\"https://reg-mirror.qiniu.com\"],\"insecure-registries\":[],\"debug\":false,\"experimental\":false,\"features\":{\"buildkit\":true}}";
        return textBlocks;
    }

    @RequestMapping(value = "/postObj", method = RequestMethod.POST)
    public Person postObj(@RequestBody Person query) {
        return query;
    }
}