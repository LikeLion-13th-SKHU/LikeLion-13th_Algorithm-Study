package daun.boj_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine()); // 목표 합

        Arrays.sort(arr); // 정렬

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if(sum == x){ // 두 수의 합이 x일 때
                count++;
                left++;
                right--;
            } else if(sum < x){ // 합이 작으면 왼쪽 포인터 이동
                left++;
            } else { // 합이 크면 오른쪽 포인터 ㅇ동
                right--;
            }
        }
        System.out.println(count);
    }
}
