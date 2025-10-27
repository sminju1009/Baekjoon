import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int answer = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }

        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]==1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int i, int j) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int count = 1;
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1];
            for (int d = 0; d<4; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (arr[ny][nx]==1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    count++;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        answer = Math.max(answer, count);
    }
}