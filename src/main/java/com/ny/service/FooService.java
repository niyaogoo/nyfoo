package com.ny.service;


import com.ny.repo.FooRepo;
import com.ny.service.entity.FooEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RestController
@RequestMapping(value = "/foo")
public class FooService {

    Logger logger = LoggerFactory.getLogger(FooService.class);

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    private FooRepo fooRepo;

    public FooService(FooRepo fooRepo) {
        this.fooRepo = fooRepo;
    }

    @Transactional
    public List<FooEntity> findByName(String name) {
        logger.debug("name:{}", name);
        List<FooEntity> list = innerFind(name);
        return list;
        //return fooRepo.findByName(name);
    }

    private List<FooEntity> innerFind(String name) {
        return em.createQuery("select e from FooEntity e where e.name=:name", FooEntity.class).setParameter("name", name).getResultList();
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFoo(String name) {
        FooEntity foo = new FooEntity();
        foo.setName(name);
        fooRepo.save(foo);
        return foo.getId();
    }

    @Transactional
    public String add(@NotNull(message = "姓名不能为空") String name, Date createDate) {
        FooEntity foo = new FooEntity();
        foo.setName(name);
        if (createDate == null) {
            foo.setCreateDate(new Date());
        }
        fooRepo.save(foo);
        return foo.getId();
    }

    public FooEntity get(String id) {
        return fooRepo.findOne(id);
    }

    @Transactional
    public void clear() {
        fooRepo.deleteAll();
    }

    @Transactional
    public void delete(String id) {
        fooRepo.delete(id);
    }

    public static String id() {
        return UUID.randomUUID().toString();
    }
}
