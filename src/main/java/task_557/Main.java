package task_557;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    static PrintWriter pw;
    static Scanner sc;
    public static void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        String[] s;
        s = sc.nextLine().split(" ");
        short m = Short.parseShort(s[0]);
        short n = Short.parseShort(s[1]);
        s = sc.nextLine().split(" ");
        short a = Short.parseShort(s[0]);
        a--;
        short b = Short.parseShort(s[1]);
        b--;
        short p = Short.parseShort(sc.nextLine());

        int[][] matA = new int[n][n];
        int[][] matB = new int[n][n];
        int[][] matC = new int[n][n];

        short i,j;
        int result, temp;

        sc.nextLine();

        for (i=0; i < n; i++){
            s = sc.nextLine().split(" ");
            for(j=0; j <n; j++){
                matA[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (short f=0; f < m-1; f++){
            sc.nextLine();
            for (i=0; i < n; i++){
                s = sc.nextLine().split(" ");
                for(j=0; j <n; j++){
                    matB[i][j] = Integer.parseInt(s[j]);
                }
            }

            for (j=0; j <n; j++){
                result =0;
                for(int k=0; k<n;k++){
                    temp = matA[a][k] * matB[k][j];
                    if(temp >= p){
                        temp = temp % p;
                    }
                    result += temp;
                    if(result >= p){
                        result = result % p;
                    }
                }
                matC[a][j] = result;
            }
            for(j=0; j <n; j++){
                matA[a][j] = matC[a][j];
            }
        }

        pw = new PrintWriter(new File("output.txt"));
        pw.print(matA[a][b]);
        pw.close();
    }
}