import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int S = 1 << 15;
        int[][] dp = new int[S][5]; 
        
        for (int i = 1; i * i < S; i++) {
            dp[i * i][1] = 1;

            for (int j = i * i; j < S; j++) {
                dp[j][2] += dp[j - i * i][1];
                dp[j][3] += dp[j - i * i][2];
                dp[j][4] += dp[j - i * i][3];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int ans = 0;
            for (int i = 1; i <= 4; i++) {
                ans += dp[n][i];
            }
            System.out.println(ans);
        }
    }
}