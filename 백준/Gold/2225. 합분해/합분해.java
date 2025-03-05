import java.util.*;
import java.io.*;

public class Main {
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[k+1][n+1];
        for (int i = 1; i<=n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i<=k; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i<=k; i++){
            for (int j = 2; j<=n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
            }
        }

        System.out.println(dp[k][n]%mod);

    }
}