package com.service.impl;

import com.service.ConvertService;

public class ConvertCurrencyServiceImpl implements ConvertService {
    @Override
    public double count( String usd , String  rate ) {
     double result = Double.parseDouble(usd)*Double.parseDouble(rate);
     return  result ;
    }
}
