package com.abilashthomas.hive;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

import java.util.ArrayList;



public class PriceAggregatorUdaf extends UDAF {

    public static class CoverageCheckEvaluator implements UDAFEvaluator{

        private ArrayList<Double> factList;

        public CoverageCheckEvaluator() {
            super();
            factList = new ArrayList<Double>();
        }

        public void init() {
            factList.clear();
        }

        public boolean iterate(Double fact) {
            factList.add(fact);
            return true;
        }


        /**
         * Terminating results that don't reach reducer
         *
         * @return
         */
        public ArrayList<Double> terminatePartial() {
            return factList;
        }

        /**
         * Merging outputs from each mapper
         *
         * @param factListTemp
         * @return
         */
        public boolean merge(ArrayList<Double> factListTemp) {
            if(factListTemp!=null)
                factList.addAll(factListTemp);
            return true;
        }

        public Double terminate() {
            Double sum = 0d;

            for(double fact:factList){
                sum += fact;
            }

            return sum;
        }
    }

}
