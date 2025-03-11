import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] K = new int[n]; 
        int[] S = new int[n]; 

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[t + 1]; 

        for (int i = 0; i < n; i++) {
            for (int j = t; j >= K[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - K[i]] + S[i]);
            }
        }

        System.out.println(dp[t]);
    }
}