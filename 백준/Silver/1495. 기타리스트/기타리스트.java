import java.util.*;
import java.io.*;

public class Main {

    static int n, s, m;
    static int[] arr;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][s] = true;
        for (int i = 1; i<=n; i++) {
            for (int j = 0; j<=m; j++) {
                if (dp[i-1][j]) {
                    if (j+arr[i-1]>=0 && j+arr[i-1]<=m) {
                        dp[i][j+arr[i-1]] = true;
                    }
                    if (j-arr[i-1]>=0 && j-arr[i-1]<=m) {
                        dp[i][j-arr[i-1]] = true;
                    }
                }
            }
        }

        for (int i = m; i>=0; i--) {
            if (dp[n][i]) {
                answer = Math.max(answer, i);
                break;
            }
        }

        System.out.println(answer);
    }

}