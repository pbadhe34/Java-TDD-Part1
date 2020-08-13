package com.data;


public class ClassWithPrivateMethods {

    public int getDataNumber(String name) {

        saveIntoDatabase(name);

        if (name == null) {
            return getDefaultNumber();
        }

        return getComputedNumber(name.length());
    }

    private void saveIntoDatabase(String name) {
        System.out.println("Saving to database with "+name);
    }

    private int getDefaultNumber() {
        return 100;
    }

    private int getComputedNumber(int length) {
        return length < 5 ? 5 : 10000;
    }

}
