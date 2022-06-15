package com.service.impl;

import com.service.CalculatorService;

public class ICalculator implements CalculatorService {
    @Override
    public float addition(float number1, float number2) {
        return number1+number2;
    }

    @Override
    public float subtraction(float number1, float number2) {
        return number1-number2;
    }

    @Override
    public float multiplication(float number1, float number2) {
        return number1*number2;
    }

    @Override
    public float division(float number1, float number2) {
        return number1/number2 ;
    }
}
