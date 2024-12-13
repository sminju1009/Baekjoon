import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            for (int j = 0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k<n; k++) {
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if (n==1) {
                System.out.println(Math.max(dp[0][0], dp[1][0]));
            } else {
                dp[0][1] += dp[1][0];
                dp[1][1] += dp[0][0];

                for (int j = 2; j<n; j++) {
                    dp[0][j] += Math.max(dp[1][j-1], dp[1][j-2]);
                    dp[1][j] += Math.max(dp[0][j-1], dp[0][j-2]);
                }
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
            }
        }
    }
}