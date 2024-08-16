import java.io.*;

// 안 밟은 경우, 직전에 한 번 밟은 경우, 직전에 두 번 연속으로 밟은 경우
public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            //  안 밟은 경우
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            // 직전에 한 번 밟은 경우
            dp[i][1] = dp[i - 1][0] + arr[i];
            // 직전에 두 번 면속으로 밟은 경우
            dp[i][2] = dp[i - 1][1] + arr[i];
        }
        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}