import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int safeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(safeArea);
    }

    public static void dfs(int level) {
        if (level==3) {
            int[][] copyArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                copyArr[i] = arr[i].clone();
            }
            bfs(copyArr);
            return;
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]==0) {
                    arr[i][j] = 1;
                    dfs(level+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(int[][] copyArr) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};

        visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (copyArr[i][j]==2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m && copyArr[ny][nx]==0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    copyArr[ny][nx] = 2;
                    q.add(new Pair(ny, nx));
                }
            }
        }

        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (copyArr[i][j]==0 && !visited[i][j]) {
                    count++;
                }
            }
        }

        safeArea = Math.max(safeArea, count);
    }
}