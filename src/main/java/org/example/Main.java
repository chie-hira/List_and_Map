package org.example;

import java.io.IOException;
import java.io.NotActiveException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /* string型のリストを作って例外処理 */

        /* Stringをいれてみる */
        List<String> userNames = new ArrayList<>();

        userNames.add("マーストン");
        userNames.add("エセル・ロジャース");
        userNames.add("トマス・ロジャース");
        userNames.add("マッカーサー将軍");
        userNames.add("エミリー・ブレント");
        userNames.add("ローレンス");
        userNames.add("アームストロング");
        userNames.add("ブロア");
        userNames.add("フィリップ・ロンバート");
        userNames.add("クレイソーン");
//        userNames.add(null); //nullは"null"になった

        /* 最初のメンバー */
        String message = callMember(userNames);
        System.out.print(message);
        System.out.println("の" + userNames.size() + "人がいます。");
        System.out.println("\r");

        /* ランダムで消えていく 誰もいなくなったら処理停止 */
        for (int i = 0; i < 20; i++) {
            /* メンバーを並び替え */
            Collections.shuffle(userNames);

            /* 最初のメンバーが消える */
            /* 誰もいない状態でエラーが発生する */
            try {
//            ここでエラーが発生する
                System.out.println(userNames.get(0) + "さんが消えました。");
                userNames.remove(0);

                if (!userNames.isEmpty()) {
                    String message2 = callMember(userNames);
                    System.out.print(message2);
                    System.out.println("の" + userNames.size() + "人になりました。");
                    System.out.println("\r");
                } else {
                    System.out.println("そして誰もいなくなった。");
//                break;
                }
            } catch (Exception e) {
                System.out.println("エラーが発生しました。");
            }
        }


        /* クラスを入れてみる */
        User nakata = new User("中田", 35, "東京都", "登山", LocalDate.of(2000, 9, 9));
        User satou = new User("佐藤", 21, "滋賀", "サッカー", LocalDate.of(2000, 2, 22));
        User urashima = new User("浦島", 42, "高知", "釣り", LocalDate.of(2000, 10, 9));
        User endo = new User("遠藤", 55, "北海道", "家庭菜園", LocalDate.of(2000, 1, 1));

//        List<User> users = new ArrayList<>();
//        users.add(nakata);
//        users.add(satou);
//        users.add(urashima);
//        users.add(endo);

        /* これなら一発で入る */
        List<User> users = List.of(nakata, satou, urashima, endo);

        /* 年齢から何年生まれか判定する */
        /* 80年代生まれのuserの趣味を出力する */
//        for (User user : users) {
//            System.out.println(user.getName());
//        }

        /* クラスをつくってマップに入れて、例外処理 */
//        hushMapは検索機能に優れている
    }

    public static String callMember(List<String> userNames) {
        StringBuilder message = new StringBuilder();
        message.append("兵隊島には");
        for (int i = 0; i < userNames.size(); i++) {
            message.append(userNames.get(i)).append("さん");
            if (i < userNames.size() - 1) {
                message.append("、");
            }
            if (i == 4) {
                message.append("\n");
            }
        }
        return message.toString();
    }
}