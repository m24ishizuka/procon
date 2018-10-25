package procon5;
import java.util.Scanner;

public class Q2 {

  public static void main(String[] args) {
    try (
      Scanner sc = new Scanner(System.in);
    ) {
      String str = sc.nextLine();

      StringBuffer sb = new StringBuffer();

      for (char c2 : str.toCharArray()) {
        if (0 < sb.length()) {
          char c1 = sb.charAt(sb.length() - 1);
          if ((c1 == 'G' && c2 == 'C') || (c1 == 'C' && c2 == 'P') || (c1 == 'P' && c2 == 'G')) {
            // 消す
            sb.delete(sb.length() - 1, sb.length());
          } else {
            // 足す
            sb.append(c2);
          }
        } else {
          sb.append(c2);
        }
      }
      
      String result = sb.toString();
      System.out.println(result.length());
    }
  }

}
