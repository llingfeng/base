package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 2016/8/30.
 */
public class PokerDemo {

    public List<Poker> pokerList;

    public PokerDemo(){
        this.pokerList = new ArrayList<Poker>();
    }

    public void comparePoker(){
        pokerList.add(new Poker("3","红桃"));
        pokerList.add(new Poker("4","方块"));
        pokerList.add(new Poker("J","红桃"));
        pokerList.add(new Poker("A","梅花"));
        pokerList.add(new Poker("3","方块"));
        System.out.println("排序前：");
        for (Poker poker : pokerList) {
            System.out.println(poker.getColor()+poker.getPoint());
        }
        Collections.sort(pokerList,new PokerCompare());
        System.out.println("排序后：");
        for (Poker poker : pokerList) {
            System.out.println(poker.getColor()+poker.getPoint());
        }
    }

    public static void main(String[] args) {
        PokerDemo pokerColor = new PokerDemo();
        pokerColor.comparePoker();
    }
}
