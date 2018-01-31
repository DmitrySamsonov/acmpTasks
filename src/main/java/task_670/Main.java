package task_670;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        short n=sc.nextShort();
        pw = new PrintWriter(new File("output.txt"));
        short i=0;
        while(n!=0){
            i++;
            if(!(isDuplicates(i)))
                n--;
        }
        pw.print(i);
        pw.close();
    }
    public boolean isDuplicates(int i){
        short b,j=0;
        short m[] = new short[5];
        while(i>0){
            b = (short) (i % 10);
            i = i /10;
            for(int p=0; p<j; p++){
                if(b == m[p]){
                    return true;
                }
            }
            m[j] = b;
            j++;
        }
        return false;
    }
}