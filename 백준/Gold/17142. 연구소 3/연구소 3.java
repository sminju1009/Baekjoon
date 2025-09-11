import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static ArrayList<int[]> virus = new ArrayList<>();
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[virus.size()];
        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int idx, int level) {
        if (level == m) {
            bfs();
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(i + 1, level + 1);
                selected[i] = false;
            }
        }
    }

    public static void bfs() {
        int[][] temp = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, n);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            if (selected[i]) {
                int y = virus.get(i)[0];
                int x = virus.get(i)[1];
                q.add(new Pair(y, x, 0));
                visited[y][x] = true;
            }
        }

        int count = 0;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (!visited[ny][nx] && temp[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    if (temp[ny][nx] == 0) {
                        count = Math.max(count, curr.level + 1);
                    }
                    q.add(new Pair(ny, nx, curr.level + 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0 && !visited[i][j]) {
                    return;
                }
            }
        }

        answer = Math.min(answer, count);
    }
}
