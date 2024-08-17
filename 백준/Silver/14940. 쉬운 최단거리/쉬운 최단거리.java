import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static int ex, ey;
    static class Pair{
        int y, x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==2) {
                    ey = i;
                    ex = j;
                }
            }
        }
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        q.add(new Pair(ey, ex));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;

            for (int i = 0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m && arr[ny][nx]!=0 && visited[ny][nx]==0 && (ny!=ey || nx!=ex)) {
                    visited[ny][nx] = visited[y][x]+1;
                    q.add(new Pair(ny, nx));
                }
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (visited[i][j]==0 && arr[i][j]!=0 && (i!=ey || j!=ex)) {
                    visited[i][j] = -1;
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
