package com.mode.responsibilitymode;

/**
 * Created by admin on 2016/12/12.
 */
public class Sales extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount <= 0.3){
            System.out.format("%s处理了折扣：%.2f%n",this.getClass().getSimpleName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
