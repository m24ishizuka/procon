package procon2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    private static final String CARD_LIST = "A234567890JQK";

    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
        ) {
            List<Integer> sList = new ArrayList<>();
            List<Integer> dList = new ArrayList<>();
            List<Integer> cList = new ArrayList<>();
            List<Integer> hList = new ArrayList<>();

            String[] cards = sc.nextLine().split(" ");
            for (String card : cards) {
                char[] cs = card.toCharArray();
                int i = CARD_LIST.indexOf(cs[1]);
                if (cs[0] == 'S') {
                    sList.add(i);
                } else if (cs[0] == 'D') {
                    dList.add(i);
                } else if (cs[0] == 'c') {
                    cList.add(i);
                } else if (cs[0] == 'H') {
                    hList.add(i);
                }
            }

            output(sList, "S");
            output(dList, "D");
            output(cList, "C");
            output(hList, "H");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void output(List<Integer> cardNoList, String type) {
        if (cardNoList.size() == 0) {
            return;
        }

        Collections.sort(cardNoList);
        for (int i = 0; i < cardNoList.size(); i++) {
            if (i == 0) {
                System.out.print(type + ":");
            } else {
                System.out.print(",");
            }
            System.out.print(CARD_LIST.charAt(cardNoList.get(i)));
        }
        System.out.println();
    }

}
