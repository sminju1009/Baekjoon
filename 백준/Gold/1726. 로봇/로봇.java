import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, x, dir, level;

        public Pair(int y, int x, int dir, int level) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.level = level;
        }
    }

    static int n, m;
    static int[][] arr;
    static int sy, sx, sdir;
    static int ey, ex, edir;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken()) - 1;
        sx = Integer.parseInt(st.nextToken()) - 1;
        sdir = Integer.parseInt(st.nextToken());
        sdir = convertDirection(sdir);

        st = new StringTokenizer(br.readLine());
        ey = Integer.parseInt(st.nextToken()) - 1;
        ex = Integer.parseInt(st.nextToken()) - 1;
        edir = Integer.parseInt(st.nextToken());
        edir = convertDirection(edir);

        bfs();
        System.out.println(count);
    }

    public static int convertDirection(int dir) {
        switch (dir) {
            case 1: return 0;
            case 2: return 2;
            case 3: return 1; 
            case 4: return 3;
            default: return 0;
        }
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx, sdir, 0));
        visited[sy][sx][sdir] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            int dir = curr.dir;
            int level = curr.level;

            if (y == ey && x == ex && dir == edir) {
                count = level;
                return;
            }

            for (int i = 1; i <= 3; i++) {
                int ny = y + dy[dir] * i;
                int nx = x + dx[dir] * i;

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;

                if (arr[ny][nx] == 1) break;

                if (!visited[ny][nx][dir]) {
                    visited[ny][nx][dir] = true;
                    q.add(new Pair(ny, nx, dir, level + 1));
                }
            }

            int leftDir = (dir + 1) % 4;
            if (!visited[y][x][leftDir]) {
                visited[y][x][leftDir] = true;
                q.add(new Pair(y, x, leftDir, level + 1));
            }
         
            int rightDir = (dir + 3) % 4;
            if (!visited[y][x][rightDir]) {
                visited[y][x][rightDir] = true;
                q.add(new Pair(y, x, rightDir, level + 1));
            }
        }
    }
}