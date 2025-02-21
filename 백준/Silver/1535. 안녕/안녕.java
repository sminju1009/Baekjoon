import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] minusHp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            minusHp[i] = Integer.parseInt(st.nextToken());
        }
        int[] joy = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][101];
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=100; j++) {
                if (minusHp[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-minusHp[i]] + joy[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][99]);
    }
}