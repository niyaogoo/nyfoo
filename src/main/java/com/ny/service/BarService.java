package com.ny.service;

import com.ny.service.entity.BarEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BarService {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public String add() {
        BarEntity bar = new BarEntity();
        em.persist(bar);
//        throw new BarException();
        return bar.getId();
    }
}
