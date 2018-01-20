package com.ny.scope;

public class SingletonBean {

    private PrototypeBean prototypeBean;

    public SingletonBean() {

    }

    public SingletonBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public String sayName() {
        return prototypeBean.name();
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
