package procon2;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
        ) {
            char[] cs = sc.nextLine().toCharArray();
            for (int i = cs.length - 1; i >= 0; i--) {
                System.out.print(cs[i]);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
