import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y;
        int x;
        int level;

        public Pair(int y, int x, int level)  {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }
    static int n, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2][n];
        for (int i = 0; i<2; i++) {
            String now = br.readLine();
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(now.charAt(j)));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[2][n];
        q.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int[] dy = {0, 0, -1, 1};
            int[] dx = {1, -1, k, k};

            for (int i = 0; i<4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];

                if ((ny==0 || ny==1) && nx>=n) {
                    return 1;
                }

                if ((ny==0 || ny==1) && nx>curr.level && arr[ny][nx]==1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx, curr.level+1));
                }
            }
        }

        return 0;
    }
}