import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr, dp;
    static int n, m;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int y, int x) {
        if (y==n-1 && x==m-1) return 1;
        if (dp[y][x] != -1) {
            return dp[y][x];
        } else {
            dp[y][x] = 0;
            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m) {
                    if (arr[y][x] > arr[ny][nx]) {
                        dp[y][x] += dfs(ny, nx);
                    }
                }
            }
        }
        return dp[y][x];
    }
}