package com.HashMap;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        var table = new hashMapFromArray(5);
        table.put(6,"A");
        table.put(8,"B");
        table.put(11,"C");
        table.put(11,"A+");
        System.out.println(table.get(10));
//        table.remove(60);
        System.out.println(table.get(11));
    }
}
