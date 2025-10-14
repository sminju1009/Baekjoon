import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static int[][] before;
    static int[][] after;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        before = new int[n][m];
        after = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        boolean isVaccinated = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    if (isVaccinated) {
                        System.out.println("NO");
                        return;
                    }
                    bfs(i, j, before[i][j], after[i][j]);
                    isVaccinated = true;
                }
            }
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        System.out.println(isSame ? "YES" : "NO");
    }

    public static void bfs(int startY, int startX, int originalNum, int newNum) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        before[startY][startX] = newNum;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if (!visited[ny][nx] && before[ny][nx] == originalNum) {
                    visited[ny][nx] = true;
                    before[ny][nx] = newNum;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}