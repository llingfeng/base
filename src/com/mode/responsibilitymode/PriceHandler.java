package com.mode.responsibilitymode;

/**
 * Created by admin on 2016/12/12.
 */
public abstract class PriceHandler {

    /**
     * 后继
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    //处理折扣
    public abstract void processDiscount(float discount);
}
