package com.mode.responsibilitymode;

/**
 * Created by admin on 2016/12/12.
 */
public class SuccessorFactory {

    public static PriceHandler createHandler(){
        PriceHandler sales = new Sales();
        PriceHandler manager = new Manager();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(manager);
        manager.setSuccessor(ceo);

        return sales;
    }
}
