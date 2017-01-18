package com.mode.responsibilitymode;

/**
 * Created by admin on 2016/12/12.
 */
public class CEO extends PriceHandler{
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.5){
            System.out.format("%s处理了折扣:%.2f%n",this.getClass().getSimpleName(),discount);
        }else {
            System.out.format("%s拒绝了折扣:%.2f%n",this.getClass().getSimpleName(),discount);
        }
    }
}
