package com.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryService {
    private static Map<String, String> dictionaries = new LinkedHashMap<>();

    static {
        dictionaries.put("xin chào", "hello");
        dictionaries.put("con gà", "chicken");
        dictionaries.put("chúc mừng", "congratulation");
        dictionaries.put("phức tạp", "complicated");
    }

    public String translate(String word) {
        return dictionaries.get(word);
    }
}
