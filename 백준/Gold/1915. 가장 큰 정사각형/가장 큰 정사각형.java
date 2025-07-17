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
            String nums = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = nums.charAt(j) - '0';
            }
        }
        int[][] dp = new int[n][m];
        int answer = 0;
        for (int i = 0; i<n; i++) {
            dp[i][0] = arr[i][0];
            answer = Math.max(dp[i][0], answer);
        }
        for (int j = 0; j<m; j++) {
            dp[0][j] = arr[0][j];
            answer = Math.max(dp[0][j], answer);
        }

        for (int i = 1; i<n; i++){
            for (int j = 1; j<m; j++) {
                if (arr[i][j]==0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        System.out.println(answer * answer);
    }
}