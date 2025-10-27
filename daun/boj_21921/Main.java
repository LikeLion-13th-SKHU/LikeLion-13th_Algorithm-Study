package daun.boj_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long window = 0;
        for (int i = 0; i < x; i++) {
            window += a[i];
        }

        long maxSum = window;
        int count = 1;

        for (int i = x; i < n; i++) {
            window += a[i]; // 새로 들어온 날
            window -= a[i - x]; // 빠져나간

            if (window > maxSum){
                maxSum = window;
                count = 1;
            } else if (window == maxSum){
                count++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }

    }
}
