package com.ny.scope;

import java.util.Random;

public class PrototypeBean {

    private String name = String.valueOf(new Random().nextInt());

    public String name() {
        return name;
    }

}
