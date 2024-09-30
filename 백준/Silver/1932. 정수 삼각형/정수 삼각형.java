import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<i+1; j++) {
                int b = Integer.parseInt(st.nextToken());
                arr[i][j] = b;
            }
        }
        dp[0][0] = arr[0][0];
        int maxi = 0;
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<=i; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
                else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+arr[i][j];
                }
                
            }
        }
        for (int i = 0; i<n; i++) {
            maxi = Math.max(maxi, dp[n-1][i]);
        }
        System.out.println(maxi);
    }
}