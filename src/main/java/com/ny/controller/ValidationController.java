package com.ny.controller;

import com.ny.service.FooService;
import com.ny.service.entity.FooEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping
public class ValidationController {

    Logger logger = LoggerFactory.getLogger(ValidationController.class);

    private FooService fooService;

    private int count = 0;

    public ValidationController(FooService fooService) {
        this.fooService = fooService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/foo/add", method = RequestMethod.GET)
    public String add(String name) {
        logger.info("count:{}", count);
        fooService.add(name, null);
        return String.valueOf(count++) + " ";
    }

    @RequestMapping(value = "/val", method = RequestMethod.GET)
    public String val(@Valid @ModelAttribute Val val, BindingResult result) {
        if (result.hasErrors()) {
            logger.error("err:{}", result.getFieldError().getDefaultMessage());
            return result.getFieldError().getCode();
        }
        logger.debug("name:{}, age:{}", val.name, val.age);
        return "valid";
    }

    @RequestMapping(value = "/foo/name", method = RequestMethod.GET)
    public String getName(String id) {
        FooEntity foo = fooService.get(id);
        return foo.getName();
    }

    @RequestMapping(value = "/foo/remark", method = RequestMethod.GET)
    public String getRemark(String id) {
        FooEntity foo = fooService.get(id);
        return foo.getRemark();
    }

    static class Val {
        @NotNull(message = "name can not be null")
        String name;

        @Min(value = 10, message = "age must bigger than 10")
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Val{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
