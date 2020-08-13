package com.data;


public class ClassForPartialMocking {

	public static String testStaticMethod() {
        return "Hello User!";
    }

	public final String finalMethod() {
        return "Hello Data!";
    }

    private String privateMethod() {
        return "Hello Privately!";
    }

    public String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }
}