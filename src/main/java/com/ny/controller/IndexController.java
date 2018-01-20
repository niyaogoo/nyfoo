package com.ny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ny.service.FooService;
import com.ny.service.entity.FooEntity;

@RestController
@RequestMapping
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    FooService fooService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        FooEntity foo = fooService.get("0ec129d9-6814-4f1b-96bb-78231ceae1c3");
        logger.debug("get foo finish");
        //        logger.debug("remark:{}", foo.getRemark());
        //return foo.getRemark();
        return "";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        fooService.findByName("test").forEach(e->
                                              {logger.debug("remark:{}",
                                                            e.getRemark());
                                              });
        return "";
    }
}
