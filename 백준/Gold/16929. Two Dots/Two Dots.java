import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static boolean flag = false;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];

                visited[i][j] = true;
                dfs(i, j, i, j, 1);

                if (flag) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    public static void dfs(int prevY, int prevX, int nowY, int nowX, int count) {
        if (flag) return;

        for (int d = 0; d < 4; d++) {
            int ny = nowY + dy[d];
            int nx = nowX + dx[d];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            if (arr[ny][nx] != arr[nowY][nowX]) continue;

            if (visited[ny][nx]) {
                if (ny != prevY || nx != prevX) {
                    flag = true;
                    return;
                }
            } else {
                visited[ny][nx] = true;
                dfs(nowY, nowX, ny, nx, count + 1);
            }
        }
    }
}