import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i<n; i++) {
            int a = arr[i];
            for (int j = 0; j<i; j++) {
                int b = arr[j];
                if (a<b) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i<n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}