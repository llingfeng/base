package com.mode.responsibilitymode;

import java.util.Random;

/**
 * Created by admin on 2016/12/12.
 */
public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    /**
     * 请求折扣
     */
    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setPriceHandler(SuccessorFactory.createHandler());
        for(int i=0;i<100;i++){
            Random random = new Random();
            customer.requestDiscount(random.nextFloat());
        }
    }
}
