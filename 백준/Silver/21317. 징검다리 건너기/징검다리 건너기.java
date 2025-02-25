import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[][] jump = new int[n][2]; 
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jump[i][0] = Integer.parseInt(st.nextToken()); 
            jump[i][1] = Integer.parseInt(st.nextToken()); 
        }

        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[1][0] = 0;
        dp[1][1] = 0;

        for (int i = 1; i < n; i++) {
            if (i + 1 <= n) {
                dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + jump[i-1][0]);
                dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1] + jump[i-1][0]);
            }

            if (i + 2 <= n) {
                dp[i+2][0] = Math.min(dp[i+2][0], dp[i][0] + jump[i-1][1]);
                dp[i+2][1] = Math.min(dp[i+2][1], dp[i][1] + jump[i-1][1]);
            }

            if (i + 3 <= n) {
                dp[i+3][1] = Math.min(dp[i+3][1], dp[i][0] + k);
            }
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}