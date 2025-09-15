package boj1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] scores = new double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = -1;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        for (int i = 0; i < n; i++) {
            sum += (scores[i] / max * 100.0);
        }

        System.out.println(sum / n);
    }
}
