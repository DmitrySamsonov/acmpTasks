package task_579;

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
        short n= Short.parseShort(sc.nextLine());
        String[] numbers = sc.nextLine().split(" ");
        short mas[] = new short[n];
        short i=0;
        for(String numb : numbers){
            mas[i] = Short.parseShort(numb);
            i++;
        }
        short[] positivePos = new short[n];
        short[] negativePos = new short[n];
        short k=0, m=0, positiveSum=0, negativeSum=0;
        for(i=0; i<n; i++){
            if(mas[i] >= 0){
                positivePos[k] = i;
                k++;
                positiveSum += mas[i];
            }else{
                negativePos[m] = i;
                m++;
                negativeSum += mas[i] * -1;
            }
        }
        pw = new PrintWriter(new File("output.txt"));
        if(positiveSum > negativeSum){
            writeResult(positivePos, k);
        } else{
            writeResult(negativePos, m);
        }
        pw.close();
    }

    private void writeResult(short[] positions, short length) {
        pw.println(length);
        boolean first = true;
        for(short i=0; i<length; i++) {
            if(first) {
                first = !first;
            } else{
                pw.print(" ");
            }
            pw.print((positions[i] + 1));
        }
    }
}