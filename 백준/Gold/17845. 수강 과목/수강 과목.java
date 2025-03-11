import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[k][2];
        for (int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];

        for (int i = 0; i<k; i++) {
            int important = arr[i][0]; // 중요도
            int time = arr[i][1]; // 시간
            for (int j = n; j>=time; j--) {
                dp[j] = Math.max(dp[j], dp[j-time] + important);
            }
        }
        System.out.println(dp[n]);
    }
}