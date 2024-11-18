import java.io.*;

public class Main {

    static boolean[] isPrime;
    static int[] dp;
    static int range = 123456*2+1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[range];
        dp = new int[range];

        prime();

        for (int i = 2; i<range; i++) {
            if (isPrime[i]) { // 소수가 아닌 경우
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a==0) break;
            int temp = dp[2*a] - dp[a];
            sb.append(temp + "\n");
        }
        System.out.println(sb);
    }

    public static void prime() {
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i<Math.sqrt(range); i++) {
            if (isPrime[i]) continue;
            for (int j = i*i; j<range; j+=i) {
                isPrime[j] = true;
            }
        }
    }
}