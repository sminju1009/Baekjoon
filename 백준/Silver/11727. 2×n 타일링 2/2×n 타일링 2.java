import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i<1001; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}