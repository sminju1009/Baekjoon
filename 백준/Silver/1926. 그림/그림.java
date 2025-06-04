import java.util.*;
import java.io.*;

public class Main {
    static int now = 0;
    static int n, m;

    static int[][] arr;
    static int count = 0;
    static int size = 0;
    static boolean[][] visited;
    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

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
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]==1 && !visited[i][j]) {
                    count++;
                    now = 1;
                    bfs(i, j);
                    size = Math.max(size, now);
                }
            }
        }
        System.out.println(count);
        System.out.println(size);
    }

    public static void bfs(int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        visited[i][j] = true;
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;
            for (int d = 0; d<4; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx));
                    now++;
                }
            }
        }
    }
}