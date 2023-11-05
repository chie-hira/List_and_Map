package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
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
                    break;
                }
            } catch (Exception e) {
                System.out.println("エラーが発生しました。");
            }
        }

        System.out.println('\r');


        /* クラスを入れてみる */
        User nakata = new User("中田", 35, "東京都", "登山", LocalDate.of(2000, 9, 9));
        User satou = new User("佐藤", 21, "滋賀", "サッカー", LocalDate.of(2000, 2, 22));
        User urashima = new User("浦島", 12, "高知", "釣り", LocalDate.of(2000, 10, 9));
        User endo = new User("遠藤", 65, "北海道", "家庭菜園", LocalDate.of(2000, 1, 1));

//        List<User> users = new ArrayList<>();
//        users.add(nakata);
//        users.add(satou);
//        users.add(urashima);
//        users.add(endo);

        /* これなら一発で入る */
        List<User> users = List.of(nakata, satou, urashima, endo);

        /* 年齢から何年生まれか判定する */
        /* 80年代生まれのuserの情報を出力する */

        /* 時点を定義する */
        LocalDate pointTime = LocalDate.of(2023, 1, 1);

        System.out.println("1980年代生まれは" + "\r");
        for (User user : users) {
//            int diff = (int) ChronoUnit.YEARS.between(pointTime, user.getBirthday());
            LocalDate realBirthdayYear = pointTime.minusYears(user.getAge());
            LocalDate realBirthday = user.getBirthday().withYear(realBirthdayYear.getYear());
            user.setBirthday(realBirthday);
//            System.out.println(realBirthday);
            if (user.getBirthday().isAfter(LocalDate.of(1980, 1, 1)) && user.getBirthday().isBefore(LocalDate.of(1990, 1, 1))) {
                System.out.println(user.getHobby() + "が趣味の" + user.getName() + "さん");
            }
        }

        int numberOfPeople = (int) users.stream().filter(item -> item.getBirthday().isAfter(LocalDate.of(1980, 1, 1)) && item.getBirthday().isBefore(LocalDate.of(1990, 1, 1))).count();
        System.out.println("の" + numberOfPeople + "名です" + "\n");

        /* 年齢順にソート */
        List<User> sortAgeUsers = users.stream().sorted(Comparator.comparing(User::getAge)).toList();
        sortAgeUsers.stream().forEach(user -> System.out.println(user.getName() + user.getAge()));

        /* 成人が含まれるか判定 */
        boolean resultAnyMatch = users.stream().anyMatch(user -> user.getAge() >= 20);
        System.out.println(resultAnyMatch);

        /* 全員が成人か判定 */
        boolean resultAllMatch = users.stream().allMatch(user -> user.getAge() >= 20);
        System.out.println(resultAllMatch);

        /* クラスをつくってマップに入れて、例外処理 */
//        HashMap:検索機能に優れている
//        キーが存在するか判定する containsKey()
//        値が存在するか判定する containsValue()
//        おすすめ:メソッドのサマリー読む
        Map<String, List> userMap = new HashMap<>();
//        userMap.put("成人", nakata);
//        userMap.put("成人", satou); //keyが同じものは置き換わる
        userMap.put("成人", List.of(nakata, satou)); //UserクラスじゃないからNG
        userMap.put("こども", List.of(urashima));
        userMap.put("高齢者", List.of(endo));

        if (userMap.containsKey("成人")) {
            List<User> adults = userMap.get("成人");
            System.out.println("成人を出力");
            adults.stream().map(adult -> adult.getName() + "さん" + adult.getAge() + "歳").forEach(System.out::println);
        }
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