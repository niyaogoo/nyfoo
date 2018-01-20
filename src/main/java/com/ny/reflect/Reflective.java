package com.ny.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public class Reflective<T> {

    private static Logger logger = LoggerFactory.getLogger(Reflective.class);

    public List<T> parameterizedList;

    public List list;

    public T[] ts;

    public void doit(T t) {

    }

    public static void main(String[] args) throws Throwable {
        Field field = Reflective.class.getField("list");
        Field parameterizedField = Reflective.class.getField("parameterizedList");
        Field tsField = Reflective.class.getField("ts");
        logger.info("list type:{}", field.getGenericType().getTypeName());

        logger.info("parameterized type:{}", parameterizedField.getGenericType().getClass().getName());
        logger.info("ts type:{}", tsField.getGenericType().getClass());

        logger.info("Reflective typeVariable:{}",
                Reflective.class.getMethod("doit", new Class[]{Object.class}).getParameterTypes());
        logger.info("is ass:{}", Reflective.class.isAssignableFrom(Object.class));
        logger.info("is ass:{}", String.class.isAssignableFrom(Reflective.class));
    }
}
