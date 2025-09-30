import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[][][] dp = new int[61][61][61];
    static int[][] hp = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<61; i++) {
            for (int j = 0; j<61; j++) {
                for (int k = 0; k<61; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        int[] scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0;i<n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dfs(scv[0], scv[1], scv[2], 0);
        System.out.println(answer);
    }

    public static void dfs(int scv1, int scv2, int scv3, int count) {
        if (count>=answer) return;
        
        if (scv1==0 && scv2==0 && scv3==0) {
            answer = Math.min(answer, count);
            return;
        }
        
        if (dp[scv1][scv2][scv3]!=-1 && dp[scv1][scv2][scv3]<=count) return;

        dp[scv1][scv2][scv3] = count;

        for (int i = 0; i<6; i++) {
            dfs(Math.max(0, scv1+hp[i][0]), Math.max(0, scv2+hp[i][1]), Math.max(0, scv3+hp[i][2]), count+1);
        }

    }
}