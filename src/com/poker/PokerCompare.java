package com.poker;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by admin on 2016/8/30.
 */
public class PokerCompare implements Comparator<Poker>{
    @Override
    public int compare(Poker o1, Poker o2) {
        String[] point = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] color = {"方块","梅花","红桃","黑桃"};
        int point1 = Arrays.asList(point).indexOf(o1.getPoint());
        int point2 = Arrays.asList(point).indexOf(o2.getPoint());
        int color1 = Arrays.asList(color).indexOf(o1.getColor());
        int color2 = Arrays.asList(color).indexOf(o2.getColor());
        if(point1-point2 != 0)
            return point2-point1;
        else
            return color2-color1;
    }
}
