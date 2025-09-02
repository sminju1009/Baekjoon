import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static class Pair {
        int y, x, level;

        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            sb.append(bfs(sy, sx, ey, ex) + "\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int sy, int sx, int ey, int ex) {
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = true;
        q.add(new Pair(sy, sx, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;
            if (y==ey && x==ex) return level;

            for (int d = 0; d<8; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny<0 || ny>=n || nx<0 || nx>=n) continue;
                if (!visited[ny][nx]) {
                    q.add(new Pair(ny, nx, level+1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }
}