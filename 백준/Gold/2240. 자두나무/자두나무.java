import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i = 1 ;i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }
        dp = new int[n+1][count+1];

        if (arr[1]==0) {
            dp[1][0] = 1;
            dp[1][1] = 0;
        } else {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 0; j<=count; j++) {
                if (j%2==0) {
                    if (j==0) {
                        if (arr[i]==0) {
                            dp[i][j] = dp[i-1][j]+1;
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                    } else {
                        if (arr[i]==0) {
                            dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                        } else {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+1);
                        }
                    }
                }
                else {
                    if (j==0) {
                        if (arr[i]==0) {
                            dp[i][j] = dp[i-1][j];
                        } else {
                            dp[i][j] = dp[i-1][j]+1;
                        }
                    } else {
                        if (arr[i]==0) {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+1);
                        } else {
                            dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i<=count; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);

    }
}