import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]==0 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;

            for (int d = 0; d<4; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny<0) ny = n-1;
                if (nx<0) nx = m-1;
                if (ny>=n) ny = 0;
                if (nx>=m) nx = 0;
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (arr[ny][nx]==0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx));
                }
            }
        }
    }
}