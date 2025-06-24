import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int h, w, sy, sx, ey, ex;
    static class Pair {
        int y, x, level;

        public Pair(int y, int x, int level) {
             this.y = y;
             this.x = x;
             this.level = level;
        }
    }
    static boolean[][] visited;
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken())-1;
        sx = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;
        ex = Integer.parseInt(st.nextToken())-1;

        prefixSum = new int[n+1][m+1];
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                prefixSum[i][j] = arr[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        if (!isPossible(sy, sx)) return -1;

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx, 0));
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;

            if (y==ey && x==ex && isPossible(y, x)) {
                return level;
            }

            for (int i = 0 ;i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny<0 || nx<0 || ny>=n || nx>=m) continue;
                if (!visited[ny][nx] && isPossible(ny, nx)) {
                    q.add(new Pair(ny, nx, level+1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }

    public static int getRangeSum(int y1, int x1, int y2, int x2) {
        return prefixSum[y2+1][x2+1] - prefixSum[y1][x2+1] - prefixSum[y2+1][x1] + prefixSum[y1][x1];
    }

    public static boolean isPossible(int y, int x) {
        if (y + h - 1 >= n || x + w - 1 >= m) {
            return false;
        }
        return getRangeSum(y, x, y + h - 1, x + w - 1) == 0;
    }
}