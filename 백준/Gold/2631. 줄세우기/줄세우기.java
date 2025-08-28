import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i<n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i<n; i++) {
            int a = arr[i];
            for (int j = 0; j<i; j++) {
                int b = arr[j];
                if (a>b) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n-max);
    }
}