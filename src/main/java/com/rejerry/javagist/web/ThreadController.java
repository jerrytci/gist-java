package com.rejerry.javagist.web;

import com.rejerry.javagist.service.ThreadService;
import com.rejerry.javagist.web.request.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "/queue", method = RequestMethod.POST)
    public String queue(@RequestBody Person query) {
        boolean data = threadService.getData();
        return "query";
    }

    @RequestMapping(value = "/timeoutFill", method = RequestMethod.POST)
    public String timeoutFill(@RequestBody Person query) {
        boolean data = threadService.getDataTimeOutFillQueue();
        return "query";
    }

    @RequestMapping(value = "/timeout", method = RequestMethod.POST)
    public String timeout(@RequestBody Person query) {
        boolean data = threadService.getDataHaveTimeOut();
        return "query";
    }
}
