package com.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/30.
 */
public class PokerPlayer {
    private int id;
    private String name;
    private List<Poker> pokers;

    public PokerPlayer(int id,String name){
        this.id = id;
        this.name = name;
        this.pokers = new ArrayList<Poker>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }

}
