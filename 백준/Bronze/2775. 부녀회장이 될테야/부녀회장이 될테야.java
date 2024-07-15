import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n + 1];

            // 0층 초기화
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            // dp 배열 채우기
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    dp[j][l] = dp[j - 1][l] + dp[j][l - 1];
                }
            }
            // 결과 출력
            System.out.println(dp[k][n]);
        }
    }
}
