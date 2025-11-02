package boj2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int sum = 0;

        int[] arr = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        for(int i=0; i<k;i++){
            sum+=arr[i];
        }
        int max = sum;
        for (int j = k; j < n; j++) {
            sum += arr[j] - arr[j-k];
            max = Math.max(max,sum);
        }
        System.out.println(max);

    }
}
