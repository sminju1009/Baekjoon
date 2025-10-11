import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static class Pair {
        int y, x, level, keys;
        Pair(int y, int x, int level, int keys) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        int sy = 0, sx = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '0') {
                    sy = i; sx = j;
                    arr[i][j] = '.';
                }
            }
        }

        visited = new boolean[n][m][64];
        System.out.println(bfs(sy, sx));
    }

    static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x, 0, 0));
        visited[y][x][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (arr[ny][nx] == '#') continue;

                if (arr[ny][nx] == '1') return curr.level + 1;

                if (arr[ny][nx] == '.' && !visited[ny][nx][curr.keys]) {
                    visited[ny][nx][curr.keys] = true;
                    q.add(new Pair(ny, nx, curr.level + 1, curr.keys));
                }
                else if (arr[ny][nx] >= 'a' && arr[ny][nx] <= 'f') {
                    int newKeys = curr.keys | (1 << (arr[ny][nx] - 'a'));
                    if (!visited[ny][nx][newKeys]) {
                        visited[ny][nx][newKeys] = true;
                        q.add(new Pair(ny, nx, curr.level + 1, newKeys));
                    }
                }
                else if (arr[ny][nx] >= 'A' && arr[ny][nx] <= 'F') {
                    int door = 1 << (arr[ny][nx] - 'A');
                    if ((curr.keys & door) > 0 && !visited[ny][nx][curr.keys]) {
                        visited[ny][nx][curr.keys] = true;
                        q.add(new Pair(ny, nx, curr.level + 1, curr.keys));
                    }
                }
            }
        }

        return -1;
    }
}
