import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;
    static int[][] dy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum) {
        answer = Math.max(answer, sum);

        if (idx == n * m) {
            return;
        }

        int y = idx / m;
        int x = idx % m;

        dfs(idx + 1, sum);

        if (visited[y][x]) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny1 = y + dy[d][0];
            int nx1 = x + dx[d][0];
            int ny2 = y + dy[d][1];
            int nx2 = x + dx[d][1];

            if (isPossible(ny1, nx1) && isPossible(ny2, nx2) &&
                    !visited[ny1][nx1] && !visited[ny2][nx2]) {

                visited[y][x] = true;
                visited[ny1][nx1] = true;
                visited[ny2][nx2] = true;

                int boomerangValue = arr[y][x] * 2 + arr[ny1][nx1] + arr[ny2][nx2];

                dfs(idx + 1, sum + boomerangValue);

                visited[y][x] = false;
                visited[ny1][nx1] = false;
                visited[ny2][nx2] = false;
            }
        }
    }

    public static boolean isPossible(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }
}