package com.codegym.concern;

import org.aspectj.lang.annotation.AfterReturning;

public class LibraryLogger {
    private static int action;
    @AfterReturning(pointcut = "execution(public * com.codegym.library.services.*.*(..))")
    public void log(){
        action++;
        System.out.println("[Log 2] -- Số lượng lượt ghé thăm thư viện: " + action);
    }
}
