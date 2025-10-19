import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int sy, sx, ey, ex;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;
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
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        visited[sy][sx] = true;
        q.add(new Pair(sy, sx, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;

            if (y==ey && x==ex) return level;

            for (int d = 0; d<6; d++) {
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