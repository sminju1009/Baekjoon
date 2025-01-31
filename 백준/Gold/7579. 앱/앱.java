import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int memory = Integer.parseInt(st.nextToken()); // 추가 확보해야 하는 메모리
        int answer = Integer.MAX_VALUE;
        int[] bytes = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }
        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][10001];
        
        for (int i = 0; i<n; i++) {
            int cost = costs[i];
            int nowMemory = bytes[i];
            
            for (int j = 0; j<10001; j++) {
                if (i==0) {
                    if (j>=cost) dp[i][j] = nowMemory;
                } else {
                    if (j>=cost) {
                        dp[i][j] = Math.max(dp[i-1][j-cost] + nowMemory, dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                
                if (dp[i][j] >= memory) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}