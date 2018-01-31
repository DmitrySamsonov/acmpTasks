package task_278;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) throws IOException {
        new Main().run();
    }

    PrintWriter pw;
    Scanner sc;

    public void run() throws IOException {
        sc = new Scanner(new File("input.txt"));
        char[] s = sc.nextLine().toCharArray();
        char[] t = sc.nextLine().toCharArray();
        pw = new PrintWriter(new File("output.txt"));
        pw.print(check(s, t));
        pw.close();
    }

    private String check(char[] s, char[] t) {
        int k = 0, m = 0;
        while (true) {
            if (k == s.length)
                return "YES";

            if (t[m] == s[k]) {
                k++;
                if (m < t.length - 1) {
                    m++;
                } else {
                    if (k < s.length)
                        return "NO";
                }
                continue;
            } else {
                if (m < t.length - 1) {
                    m++;
                } else {
                    return "NO";
                }
            }
        }
    }
}