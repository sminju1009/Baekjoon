import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n][m][3];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                for (int k = 0; k<3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // 이동할 수 없는 경우(첫줄)
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        for (int i = 1; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (j==0) {
                    dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                } else if (j>=1 && j<m-1) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                } else if (j==m-1) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<3; j++) {
                result = Math.min(dp[n-1][i][j], result);
            }
        }

        System.out.println(result);
    }
}