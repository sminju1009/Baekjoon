import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y;
        int x;
        int dist;

        public Pair(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static int n, m;
    static char[][] arr;
    static int max = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(int sy, int sx) {
        boolean[][] visited = new boolean[n][m];
        visited[sy][sx] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx, 0));
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            int dist = curr.dist;
            max = Math.max(dist, max);

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx] && arr[ny][nx]=='L') {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx, dist+1));
                }
            }
        }
    }
}