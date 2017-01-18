package com.poker;

import java.util.*;

/**
 * Created by admin on 2016/8/30.
 */
public class Main {

    public List<Poker> pokerList;
    public List<PokerPlayer> pokerPlayerList;

    public Main() {
        this.pokerList = new ArrayList<Poker>();
        this.pokerPlayerList = new ArrayList<PokerPlayer>();
    }

    /**
     * 创建扑克
     */
    public void createPoker() {
        System.out.println("- - -创建扑克- - -");
        String[] point = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] color = {"方块", "梅花", "红桃", "黑桃"};
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < point.length; j++) {
                pokerList.add(new Poker(color[i], point[j]));
            }
        }
        System.out.println("- - -扑克牌创建成功- - -");
        for (Poker poker : pokerList) {
            System.out.print(poker.getColor() + poker.getPoint() + "\t");
        }
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        System.out.println("\n- - -开始洗牌- - -");
        List<Poker> tempList = new ArrayList<Poker>();
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int num = random.nextInt(52 - i);
            Poker poker = pokerList.get(num);
            tempList.add(poker);
            pokerList.remove(num);
        }
        pokerList = tempList;
        for (Poker poker : pokerList) {
            System.out.print(poker.getColor() + poker.getPoint() + "\t");
        }
        System.out.println("\n- - -洗牌结束- - - ");
    }

    /**
     * 创建选手
     */
    public void createPlay() {
        System.out.println("- - -创建玩家- - -");
        Scanner input = new Scanner(System.in);
        int num = 1;
        do{
            try {
                System.out.println("请输入第"+num+"位玩家的ID和姓名：");
                int id = code();
                System.out.println("请输入姓名：");
                String name = input.next().trim();
                pokerPlayerList.add(new PokerPlayer(id,name));
                num++;
            } catch (ErrorCodeException e) {
                System.out.println(e.getMessage());
            }
        }while (num<3);
        System.out.println("- - -欢迎玩家:"+pokerPlayerList.get(0).getName());
        System.out.println("- - -欢迎玩家:"+pokerPlayerList.get(1).getName());
    }

    /**
     * 输入异常处理
     * @return
     * @throws ErrorCodeException
     */
    public int code() throws ErrorCodeException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入ID：");
        try {
            int id = input.nextInt();
            return id;
        } catch (Exception e) {
            throw new ErrorCodeException("格式错误！");
        }
    }

    /**
     * 发牌
     */
    public void cutPoker(){
        System.out.println("- - - - -开始发牌- - - - -");
        List<Poker> tempList1 = new ArrayList<>();
        List<Poker> tempList2 = new ArrayList<>();
        for(int i=0;i<4;i++){
            if(i%2==0){
                System.out.println("玩家:"+pokerPlayerList.get(0).getName()+"-拿牌");
                tempList1.add(pokerList.get(i));
            }else{
                System.out.println("玩家:"+pokerPlayerList.get(1).getName()+"-拿牌");
                tempList2.add(pokerList.get(i));
            }
        }
        pokerPlayerList.get(0).setPokers(tempList1);
        pokerPlayerList.get(1).setPokers(tempList2);
        System.out.println("- - - - -发牌结束- - - - -");
    }

    /**
     * 开始游戏
     */
    public void startGame(){
        System.out.println("- - - - -开始游戏- - - - -");
        List<Poker> maxPokerList = new ArrayList<>();
        Map maxPokerMap = new HashMap();
        for(int i=0;i<2;i++){
            PokerPlayer pokerPlayer = pokerPlayerList.get(i);
            List<Poker> pokers = pokerPlayer.getPokers();
            Collections.sort(pokers,new PokerCompare());
            Poker maxPoker = pokers.get(0);
            maxPokerList.add(maxPoker);
            maxPokerMap.put(maxPoker,pokerPlayer);
            System.out.println("玩家："+pokerPlayer.getName()+"最大的手牌为:"+maxPoker.getColor()+maxPoker.getPoint());
        }
        Collections.sort(maxPokerList,new PokerCompare());
        PokerPlayer pokerPlayer = (PokerPlayer) maxPokerMap.get(maxPokerList.get(0));
        System.out.println("- - - - -玩家："+pokerPlayer.getName()+"获胜- - - - -");
        System.out.println("玩家各自的手牌为：");
        for (PokerPlayer player : pokerPlayerList) {
            System.out.println(player.getName()+":"+player.getPokers());
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.createPoker();
        test.shuffle();
        test.createPlay();
        test.cutPoker();
        test.startGame();
    }
}
