package procon5;

import java.util.Scanner;

public class Q1 {

  public static void main(String[] args) {
    try (
      Scanner sc = new Scanner(System.in);
    ) {
      String str = sc.nextLine();
      
      char era = str.charAt(0);
      int num = Integer.parseInt(str.substring(1));
      
      int start
          = (era == 'M') ? 1868
          : (era == 'T') ? 1912
          : (era == 'S') ? 1926
          : (era == 'H') ? 1989
          : 2019;

      int result = start + num - 1;
      System.out.println(result);
    }
  }

}
