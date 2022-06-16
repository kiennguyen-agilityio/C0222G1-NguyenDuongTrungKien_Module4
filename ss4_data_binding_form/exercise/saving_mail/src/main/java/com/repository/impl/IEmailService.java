package com.repository.impl;

import com.repository.EmailService;

import java.util.ArrayList;
import java.util.List;

public class IEmailService implements EmailService {
    @Override
    public List<String> language() {
        List<String> language = new ArrayList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");
        return language;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(25);
        pageSizes.add(20);
        pageSizes.add(15);
        pageSizes.add(10);
        return pageSizes;
    }
}
