package com.app;

/**
 * Created by admin on 2016/10/30.
 */
public class Poker {
    private static String[] suites = {"黑桃","红桃","梅花","方块"};
    private static int[] faces = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private Card[] cards;

    //构造器
    public Poker() {
        cards = new Card[52];
        for(int i=0;i<suites.length;i++){
            for(int j=0;j<faces.length;j++){
                cards[13*i+j] = new Card(suites[i],faces[j]);
            }
        }
    }

    //洗牌
    public void shuffle(){
        for(int i=0;i<cards.length;i++){
            int index = (int)(Math.random()*cards.length);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }

    //发牌
    public Card deal(int index){
        return cards[index-1];
    }

    //内部类
    public class Card{
        private String suite;//花色
        private int face;//点数

        public int getFace() {
            return face;
        }

        public void setFace(int face) {
            this.face = face;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }

        @Override
        public String toString() {
            String faceStr = "";
            switch (face){
                case 1: faceStr = "A";break;
                case 11: faceStr = "J";break;
                case 12: faceStr = "Q";break;
                case 13: faceStr = "K";break;
                default: faceStr = String.valueOf(face);
            }
            return suite+faceStr;
        }
    }

    public static void main(String[] args){
        Poker poker = new Poker();
        poker.shuffle();
        Poker.Card c1 = poker.deal(1);//洗牌后的第一张牌
        System.out.println(c1);
        Poker.Card card = poker.new Card("红桃",1);
        System.out.println(card);
    }
}
