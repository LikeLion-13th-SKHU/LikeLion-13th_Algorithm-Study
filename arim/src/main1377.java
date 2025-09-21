import java.util.*;

public class main1377 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int minAdd = 5;

        for (int i = 0; i < n; i++) {
            int count = 1;
            int current = arr[i];

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < current + 5) {
                    count++;
                } else {
                    break;
                }
            }
            minAdd = Math.min(minAdd, 5 - count);
        }

        System.out.println(minAdd);
    }
}
