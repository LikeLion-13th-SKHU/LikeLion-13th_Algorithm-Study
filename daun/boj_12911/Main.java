package daun.boj_12911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer score = new StringTokenizer(in.readLine()); // n개 점수 한줄에 입력
        int[] scores = new int[n];

        int max = 0;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(score.nextToken());
            sum += scores[i];
            if(scores[i] > max) {
                max = scores[i];
            }
        }

        double ave = (sum /max * 100) / n;
        System.out.println(ave);
    }
}
