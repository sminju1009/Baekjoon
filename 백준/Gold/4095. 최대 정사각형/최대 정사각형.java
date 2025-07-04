import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int max = 0;

            if (n==0||m==0) break;

            int[][] arr = new int[n][m];
            for (int i = 0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j<m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][m];

            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (arr[i][j]==0) {
                        dp[i][j] = 0;
                    } else if (i==0 || j==0) {
                        dp[i][j] = 1;
                        max = Math.max(dp[i][j], max);
                    } else {
                        if (dp[i][j-1]>0 && dp[i-1][j]>0 && dp[i-1][j-1]>0) {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
            sb.append(max + "\n");

        }

        System.out.println(sb);
    }
}