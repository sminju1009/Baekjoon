import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (j==0) {
                    dp[i][j] = arr[i][j];
                }
                else {
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                }
            }
        }
        for (int i = 0; i<m; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            for (int j = sy-1; j<ey; j++) {
                if (sx!=1) {
                    answer += (dp[j][ex-1] - dp[j][sx-2]);
                } else {
                    answer += dp[j][ex-1];
                }

            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}