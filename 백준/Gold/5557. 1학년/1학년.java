import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i<n-1; i++) {
            for (int j = 0; j<=20; j++) {
                if (dp[i-1][j]!=0) {
                    int plus = j+arr[i];
                    int minus = j-arr[i];
                    if (plus>=0 && plus<=20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus>=0 && minus<=20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);

    }
}