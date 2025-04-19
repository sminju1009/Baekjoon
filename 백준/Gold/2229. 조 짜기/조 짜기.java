import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[j-1] + getScore(j, i));
            }
        }
        System.out.println(dp[n]);
    }

    public static int getScore(int start, int end) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start-1; i<=end-1; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max-min;
    }
}