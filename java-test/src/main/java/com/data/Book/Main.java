package com.data.Book;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        booknodes first = new booknodes("Andrey", "Krutogolov", "Biggest Ass");
        //fullbook book = new fullbook<>(10, new booknodes("Andrey", "Krutogolov", "Biggest Ass"));
        HashMap book = new HashMap();
        book.put("sys admin", new booknodes("loh", "Chel"));
        book.put("test", new booknodes("Mom", "Ch", "Gta"));
        System.out.println(book.get("sys admin").toString());
        //System.out.println(book.putIfAbsent());
        //System.out.println(book.keySet());
    }
}
