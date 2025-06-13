import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[][] dp = new int[2][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i<=n; i++) {
            if (arr[i]==1) {
                dp[0][i] = dp[0][i-1] + 1;
                max = Math.max(max, dp[0][i]);
                dp[1][i] = Math.max(0, dp[1][i-1]-1);
                max = Math.max(max, dp[1][i]);
            } else {
                dp[0][i] = Math.max(0, dp[0][i-1]-1);
                max = Math.max(max, dp[0][i]);
                dp[1][i] = dp[1][i-1] + 1;
                max = Math.max(max, dp[1][i]);
            }
        }
        System.out.println(max);
    }
}