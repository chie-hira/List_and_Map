package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        クラスをつくって、リストに入れて分岐、例外処理
//        指定した型しか入らない

        /* Stringをいれてみる */
        List<String> userNames = new ArrayList<>();

        userNames.add("中田");
        userNames.add("佐藤");
        userNames.add("浦島");
        userNames.add("遠藤");

        for (String userName : userNames
             ) {
            System.out.println(userName);
        }

        /* クラスを入れてみる */
        User nakata = new User("中田", 35, "東京都", "登山", LocalDate.of(2000,9,9));
        User satou = new User("佐藤", 21, "滋賀", "サッカー", LocalDate.of(2000, 2,22));
        User urashima = new User("浦島", 42, "高知", "釣り", LocalDate.of(2000,10,9));
        User endo = new User("遠藤", 55, "北海道", "家庭菜園", LocalDate.of(2000, 1,1));

//        List<User> users = new ArrayList<>();
//        users.add(nakata);
//        users.add(satou);
//        users.add(urashima);
//        users.add(endo);

        /* これなら一発で入る */
        List<User> users = List.of(nakata, satou, urashima, endo);

        /* 年齢から何年生まれか判定する */
        /* 80年代生まれのuserの趣味を出力する */
        for (User user : users) {
            System.out.println(user.getName());
        }






//        クラスをつくって、マップに入れる分岐、例外処理
        System.out.println("Hello world!");
    }
}