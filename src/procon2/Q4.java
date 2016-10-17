package procon2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q4 {

    private static final int SCREEN_SIZE_X = 80;
    private static final int SCREEN_SIZE_Y = 25;
    private static final Pattern CMD_PATTERN = Pattern.compile("(\\x1b\\[2J|\\x1b\\[[0-9]+(A|D|B|C)|\\x1b\\[[0-9]+;[0-9]+H)");

    private static char[][] screen = new char[SCREEN_SIZE_Y][SCREEN_SIZE_X];
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) {
        String[] lines = null;
        try (
            Scanner sc = new Scanner(System.in);
        ) {
            int lineCount = Integer.parseInt(sc.nextLine());
            lines = new String[lineCount];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = sc.nextLine();
            }

            clear();

            for (String line : lines) {
                Matcher matcher = CMD_PATTERN.matcher(line);
                int startI = 0;
                int endI = 0;
                while (matcher.find()) {
                    endI = matcher.start();
                    String str = line.substring(startI, endI);
                    write(str);
                    startI = matcher.end();
                    String cmd = matcher.group();
                    move(cmd);
                }
                write(line.substring(startI, line.length()));
            }

            // output
            for (int yi = 0; yi < SCREEN_SIZE_Y; yi++) {
                for (int xi = 0; xi < SCREEN_SIZE_X; xi++) {
                    System.out.print(screen[yi][xi]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void clear() {
        for (int yi = 0; yi < SCREEN_SIZE_Y; yi++) {
            for (int xi = 0; xi < SCREEN_SIZE_X; xi++) {
                screen[yi][xi] = ' ';
            }
        }
    }

    private static void write(String str) {
        for (int i = 0; i < str.length(); i++) {
            screen[y][x++] = str.charAt(i);
            if (x == SCREEN_SIZE_X) {
                x = 0;
                y = y + 1;
            }
            if (y == SCREEN_SIZE_Y) {
                for (int yi = 0; yi < screen.length - 1; yi++) {
                    screen[yi] = screen[yi + 1];
                }
                screen[SCREEN_SIZE_Y - 1] = new char[SCREEN_SIZE_X];
                for (int xi = 0; xi < SCREEN_SIZE_X; xi++) {
                    screen[SCREEN_SIZE_Y - 1][xi] = ' ';
                }
                y = SCREEN_SIZE_Y - 1;
            }
        }
    }

    private static void move(String cmd) {
        char type = cmd.charAt(cmd.length() - 1);
        if (type == 'J') {
            clear();
            x = 0;
            y = 0;
        } else if (type == 'H') {
            int semicolonI = cmd.indexOf(';');
            int m = Integer.parseInt(cmd.substring(2, semicolonI));
            int n = Integer.parseInt(cmd.substring(semicolonI + 1, cmd.length() - 1));
            x = n - 1;
            y = m - 1;
        } else {
            int n = Integer.parseInt(cmd.substring(2, cmd.length() - 1));
            if (type == 'B') {
                y = y + n;
            } else if (type == 'D') {
                x = x - n;
            } else if (type == 'C') {
                x = x + n;
            } else if (type == 'A') {
                y = y - n;
            }
        }
    }

}
