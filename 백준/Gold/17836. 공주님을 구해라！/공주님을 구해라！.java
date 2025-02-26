import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, x, level;
        boolean hasSword;

        public Pair(int y, int x, int level, boolean hasSword) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.hasSword = hasSword;
        }
    }

    static int n, m, t;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int swordY = -1, swordX = -1;
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    swordY = i;
                    swordX = j;
                }
            }
        }

        int answer = bfs();

        System.out.println((answer <= t) ? answer : "Fail");
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        q.add(new Pair(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.y == n - 1 && curr.x == m - 1) {
                return curr.level;
            }

            int[] dy = {0, 1, 0, -1};
            int[] dx = {1, 0, -1, 0};

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if (curr.hasSword) {
                    if (!visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new Pair(ny, nx, curr.level + 1, true));
                    }
                } else {
                    if (arr[ny][nx] != 1 && !visited[ny][nx][0]) {
                        boolean nextHasSword = (arr[ny][nx] == 2);
                        visited[ny][nx][nextHasSword ? 1 : 0] = true;
                        q.add(new Pair(ny, nx, curr.level + 1, nextHasSword));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}