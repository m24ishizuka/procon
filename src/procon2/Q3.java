package procon2;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
        ) {
            char[] balls = sc.nextLine().toCharArray();
            int r = 0;
            int g = 0;
            int b = 0;
            for (char ball : balls) {
                if (ball == 'R') {
                    r++;
                } else if (ball == 'G') {
                    g++;
                } else if (ball == 'B') {
                    b++;
                }
            }
            int result = (r % 2) + (g % 2) + (b % 2);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
