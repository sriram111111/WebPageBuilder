package com.demo1.demo1.utilities;

public class IDGenerator {

    static int i = 0;
    public static String generateID(){
        i++;
        return i+"";
    }

    static int add = 0;
    public static String generateAddID() {
        add++;
        return "add"+add;
    }
}
