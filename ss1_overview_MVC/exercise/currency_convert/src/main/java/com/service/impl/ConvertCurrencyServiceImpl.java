package com.service.impl;

import com.service.ConvertService;

public class ConvertCurrencyServiceImpl implements ConvertService {
    @Override
    public double count( String usd , String  rate ) {
     float result = Float.parseFloat(usd)*Float.parseFloat(rate);
     return  result ;
    }
}
