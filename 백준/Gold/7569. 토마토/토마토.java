import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int height, y, x;

        public Pair(int height, int y, int x) {
            this.height = height;
            this.y = y;
            this.x = x;
        }
    }

    static int m, n, h;
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int level = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.add(new Pair(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        // 토마토가 다 익은 경우 1이고 이때는 bfs 돌리지 말고 0 출력
        int flag = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        flag = 0;
                        break;
                    }
                }
            }
        }
        if (flag == 1) {
            System.out.println(0);
        } else {
            int[] dh = {0, 0, 0, 0, -1, 1};
            int[] dy = {1, 0, -1, 0, 0, 0};
            int[] dx = {0, 1, 0, -1, 0, 0};

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                int height = curr.height, y = curr.y, x = curr.x;

                for (int i = 0; i < 6; i++) {
                    int nh = height + dh[i];
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (nh >= 0 && nh < h && ny >= 0 && ny < n && nx >= 0 && nx < m && arr[nh][ny][nx] == 0 && !visited[nh][ny][nx]) {
                        visited[nh][ny][nx] = true;
                        arr[nh][ny][nx] = arr[height][y][x] + 1;
                        q.add(new Pair(nh, ny, nx));
                        level = Math.max(level, arr[nh][ny][nx]);
                    }
                }
            }
            int available = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (arr[i][j][k] == 0) {
                            available = -1;
                            break;
                        }
                    }
                }
            }
            if (available == -1) {
                System.out.println(-1);
            } else {
                System.out.println(level-1);
            }

        }
    }
}