import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int n, m, k;
    static int max = Integer.MIN_VALUE;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static boolean isAdjacent(int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m && visited[ny][nx]) {
                return true; 
            }
        }
        return false;
    }
    public static void dfs(int level, int sum, int idx) {
        if (level == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = idx; i < n * m; i++) {
            int y = i / m;
            int x = i % m;

            if (!visited[y][x] && !isAdjacent(y, x)) {
                visited[y][x] = true;
                dfs(level + 1, sum + arr[y][x], i + 1);
                visited[y][x] = false; 
            }
        }
    }
}