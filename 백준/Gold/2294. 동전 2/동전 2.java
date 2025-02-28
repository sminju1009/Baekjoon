import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for (int i = 0; i<n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        int INF = 987654321;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i<n; i++) {
            for (int j = money[i]; j<=k; j++) {
                dp[j] = Math.min(dp[j], dp[j-money[i]]+1);
            }
        }

        if (dp[k]==INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}