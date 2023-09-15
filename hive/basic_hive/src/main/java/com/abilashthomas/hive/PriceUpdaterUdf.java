package com.abilashthomas.hive;

import org.apache.hadoop.hive.ql.exec.UDF;


public class PriceUpdaterUdf extends UDF {
    public double evaluate(double price, double multiplier){
        return price*multiplier;
    }
}
