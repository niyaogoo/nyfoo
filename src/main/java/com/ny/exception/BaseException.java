package com.ny.exception;

/**
 *
 */
public class BaseException extends Exception {

    public String getMessage() {
        return "base exception";
    }

    public static void main(String[] args) {
        try {
            throw new BaseException();
        } catch (ChildException e) {
            System.out.println(e.getMessage());
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }
}
