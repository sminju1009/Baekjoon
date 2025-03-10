import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[][] dp = new int[n+1][m+1];
            for (int i = 1; i<=n; i++) {
                dp[i][0] = 1;

                for (int j = 1; j<=m; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (j>=arr[i]) dp[i][j] += dp[i][j-arr[i]];
                }
            }
            sb.append(dp[n][m] + "\n");
        }
        System.out.println(sb);
    }
}