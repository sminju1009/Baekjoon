import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int y, int x) {
        if (dp[y][x]!=0) {
            return dp[y][x];
        }

        dp[y][x] = 1;
        for (int i = 0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if (ny>=0 && ny<n && nx>=0 && nx<n) {
                if (arr[y][x]<arr[ny][nx]) {
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx)+1);
                    dfs(ny, nx);
                }
            }
        }
        return dp[y][x];
    }
}