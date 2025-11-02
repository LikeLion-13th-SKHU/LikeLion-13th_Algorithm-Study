package boj12891;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int S = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);
        char[] dna = br.readLine().toCharArray();
        String[] cond = br.readLine().split(" ");
        int[] checkArr = new int[4];
        int[] myArr = new int[4];
        int checkSecret = 0;
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(cond[i]);
            if (checkArr[i] == 0) checkSecret++;
        }
        for (int i = 0; i < P; i++) {
            char c = dna[i];
            if (c == 'A') { myArr[0]++; if (myArr[0] == checkArr[0]) checkSecret++; }
            else if (c == 'C') { myArr[1]++; if (myArr[1] == checkArr[1]) checkSecret++; }
            else if (c == 'G') { myArr[2]++; if (myArr[2] == checkArr[2]) checkSecret++; }
            else { myArr[3]++; if (myArr[3] == checkArr[3]) checkSecret++; }
        }
        int result = 0;
        if (checkSecret == 4) result++;
        for (int i = P; i < S; i++) {
            int j = i - P;
            char add = dna[i], remove = dna[j];
            if (add == 'A') { myArr[0]++; if (myArr[0] == checkArr[0]) checkSecret++; }
            else if (add == 'C') { myArr[1]++; if (myArr[1] == checkArr[1]) checkSecret++; }
            else if (add == 'G') { myArr[2]++; if (myArr[2] == checkArr[2]) checkSecret++; }
            else { myArr[3]++; if (myArr[3] == checkArr[3]) checkSecret++; }
            if (remove == 'A') { if (myArr[0] == checkArr[0]) checkSecret--; myArr[0]--; }
            else if (remove == 'C') { if (myArr[1] == checkArr[1]) checkSecret--; myArr[1]--; }
            else if (remove == 'G') { if (myArr[2] == checkArr[2]) checkSecret--; myArr[2]--; }
            else { if (myArr[3] == checkArr[3]) checkSecret--; myArr[3]--; }
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
    }
}
