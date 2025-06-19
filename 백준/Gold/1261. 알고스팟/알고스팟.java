import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static class Pair implements Comparable<Pair> {
        int y, x, level;

        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;

        }
        @Override
        public int compareTo(Pair o) {
            return level - o.level;
        }

    }
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        visited[0][0] = true;
        q.add(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair now = q.poll();
            int y = now.y, x = now.x, level = now.level;

            if (y==n-1 && x==m-1) {
                return level;
            }

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=n || ny<0 || nx>=m || nx<0) continue;
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (arr[ny][nx]==0) {
                        q.add(new Pair(ny, nx, level));
                    } else {
                        q.add(new Pair(ny, nx, level+1));
                    }
                }
            }
        }
        return -1;
    }
}