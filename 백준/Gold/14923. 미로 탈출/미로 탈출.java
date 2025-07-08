import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y, x, level, wall;

        public Pair(int y, int x, int level, int wall) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.wall = wall;
        }
    }
    static int n, m;
    static boolean[][][] visited;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m][2];
        st = new StringTokenizer(br.readLine());
        int hy = Integer.parseInt(st.nextToken()) -1;
        int hx = Integer.parseInt(st.nextToken()) -1;
        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken()) -1;
        int ex = Integer.parseInt(st.nextToken()) -1;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(hy, hx, ey, ex));
    }

    public static int bfs(int hy, int hx, int ey, int ex) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(hy, hx, 0, 0));
        visited[hy][hx][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level, wall = curr.wall;

            if (y==ey && x==ex) {
                return level;
            }

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m) {
                    if (arr[ny][nx]==0) {
                        if (!visited[ny][nx][wall]) {
                            visited[ny][nx][wall] = true;
                            q.add(new Pair(ny, nx, level+1, wall));
                        }
                    } else {
                        if (wall==0 && !visited[ny][nx][1]) {
                            visited[ny][nx][1] = true;
                            q.add(new Pair(ny, nx, level+1, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}