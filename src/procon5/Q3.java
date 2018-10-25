package procon5;
import java.util.Scanner;

public class Q3 {

  public static void main(String[] args) {
    try (
      Scanner sc = new Scanner(System.in);
    ) {
      // A種進数
      int baseA = sc.nextInt();
      String[] signsA = new String[baseA];
      for (int i = 0; i < baseA; i++) {
        signsA[i] = sc.next();
      }

      // B種進数
      int baseB = sc.nextInt();
      String[] signsB = new String[baseB];
      for (int i = 0; i < baseB; i++) {
        signsB[i] = sc.next();
      }

      // C種進数
      int baseC = sc.nextInt();
      String[] signsC = new String[baseC];
      for (int i = 0; i < baseC; i++) {
        signsC[i] = sc.next();
      }

      int cDigit = sc.nextInt();

      String strA = sc.next();
      String strB = sc.next();
      
      // 10種進数
      int base10A = toBase10(signsA, strA);
      int base10B = toBase10(signsB, strB);
      int base10C = base10A + base10B;

      StringBuffer strC = toBaseN(signsC, base10C);

      // 最初の記号で埋める
      int signLenC = signsC[0].length();
      while (strC.length() < signLenC * cDigit) {
        strC.insert(0, signsC[0]);
      }

      System.out.println(strC.toString());
    }
  }

  private static int toBase10(String[] signs, String str) {
    // 基数（{ aa, bb, cc, dd, ee } -> 5）
    int base = signs.length;

    // 1文字の長さ（{ aa, bb, cc, dd, ee } -> 2）
    int signLen = signs[0].length();

    // 桁（eeaacc -> 3）
    int digit = str.length() / signLen;

    int result = 0;
    double power = Math.pow(base, digit - 1);
    for (int i = 0; i < digit; i++, power /= base) {
      String sign = str.substring(i * signLen, i * signLen + signLen);
      int base10 = findIndex(signs, sign);
      result += (base10 * power);
    }

    return result;
  }

  private static StringBuffer toBaseN(String[] signs, int base10) {
    // 基数
    int base = signs.length;
    // 商
    int quot = base10;
    StringBuffer sb = new StringBuffer();
    while (quot != 0) {
      // 余り
      int rem = quot % base;
      quot /= base;
      String sign = signs[rem];
      sb.insert(0, sign);
    }
    return sb;
  }

  private static int findIndex(String[] array, String str) {
    for (int i = 0; i < array.length; i++) {
      if (str.equals(array[i])) {
        return i;
      }
    }
    return -1;
  }

}
