import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][n];
        boolean flag = false;
        if (arr[0][0]==0) {
            flag = true;
            dp[0][0] = 1;
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (!flag) {
                    if (arr[i][j]==0) {
                        flag = true;
                        dp[i][j] = 1;
                    }
                } else {
                    if (i==0 && j==0) {
                        continue;
                    } else if (i==0) {
                        if (dp[i][j-1]%3 == arr[i][j]%3) {
                            dp[i][j] = dp[i][j-1]+1;
                        } else {
                            dp[i][j] = dp[i][j-1];
                        }
                    } else if (j==0) {
                        if (dp[i-1][j]%3 == arr[i][j]%3) {
                            dp[i][j] = dp[i-1][j]+1;
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                    } else {
                        int a = 0, b = 0;
                        if (dp[i][j-1]%3 == arr[i][j]%3) {
                            a = dp[i][j-1]+1;
                        } else {
                            a = dp[i][j-1];
                        }
                        if (dp[i-1][j]%3 == arr[i][j]%3) {
                            b = dp[i-1][j]+1;
                        } else {
                            b = dp[i-1][j];
                        }
                        dp[i][j] = Math.max(a, b);
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}