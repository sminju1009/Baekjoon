import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            int[] dp = new int[money+1];
            for (int i = 1; i<=n; i++) {
                for (int j = 1; j<=money; j++) {
                    if (j-coins[i] > 0) {
                        dp[j] = dp[j] + dp[j-coins[i]];
                    } else if (j-coins[i]==0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[money] + "\n");
        }
        System.out.println(sb);
    }
}