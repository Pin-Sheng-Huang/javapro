package poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: javasepromax
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2024-03-24 16:01
 * @LastEditTime: 2024-03-24 16:01
 */

public class PokerGame {

    //牌盒
    static ArrayList<String> list = new ArrayList<>();


    //准备牌
    //静态代码块
    //特点:随着PokerGame类加载到內存就加载的
    /* 黑桃♠、紅心♥、梅花♣、方塊♦*/
    /* "3","4","5","6","7","8","9","10","J","Q","K","A","2" */
    static {
        String[] color= {"♠","♥","♦","♣"};
        String [] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};


        for (String c : color) {
            for (String n : number) {
                list.add(c+n);
            }
        }
        list.add("Joker1");
        list.add("Joker2");



    }


    public PokerGame(){
        //System.out.println(list);
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String>lord = new ArrayList<>();
        ArrayList<String>P1 = new ArrayList<>();
        ArrayList<String>P2 = new ArrayList<>();
        ArrayList<String>P3 = new ArrayList<>();



        //遍历牌和得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if(i <= 2){
                lord.add(poker);
                continue;
            }

            //三個玩家輪流發排
            //i % 3取餘數發牌給三個玩家
            if(i % 3 == 0){
                P1.add(poker);
            }else  if(i % 3 == 1){
                P2.add(poker);
            }else{
                P3.add(poker);
            }
        }

        //看牌
        looPoker("底牌",lord);
        looPoker("神",P1);
        looPoker("魔",P2);
        looPoker("阿昇",P3);
    }
    /*
    * 参数玩家名,每位玩家的牌
    * * */
    public void looPoker(String name, ArrayList<String> list){
        System.out.print(name + ": ");

        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
