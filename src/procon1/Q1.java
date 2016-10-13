package procon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
        ) {
            int volumeTotal = Integer.parseInt(sc.nextLine());

            List<Integer> myList = getIntegerList(sc.nextLine(), volumeTotal);
            List<Integer> shopList = getIntegerList(sc.nextLine(), volumeTotal);

            List<Integer> buyList = new ArrayList<>();
            for (int vol : shopList) {
                if (!myList.contains(vol)) {
                    buyList.add(vol);
                }
            }
            Collections.sort(buyList);

            // 出力
            if (buyList.size() == 0) {
                System.out.println("None");
            } else {
                for (int i = 0; i < buyList.size(); i++) {
                    if (i > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(buyList.get(i));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getIntegerList(String line, int max) {
        String[] strs = line.split(" ");
        List<Integer> list = new ArrayList<>();

        // 1桁目が0でなければ変換する
        if ("0".equals(strs[0])) {
            for (String str : strs) {
                int toInteger = Integer.parseInt(str);
                if (toInteger <= max) {
                    list.add(toInteger);
                }
            }
        }
        return list;
    }

}
