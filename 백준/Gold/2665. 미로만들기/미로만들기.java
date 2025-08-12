import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    static int[][] arr;
    static boolean[][][] visited;
    static class Pair implements Comparable<Pair> {
        int y, x, level;

        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.level, other.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[n][n][n*n];
        System.out.println(bfs());
    }

    public static int bfs() {

        PriorityQueue<Pair> q= new PriorityQueue<>();

        q.add(new Pair(0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;

            if (y==n-1 && x==n-1) {
                return level;
            }

            for (int d = 0; d<4; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny>=0 && ny<n && nx>=0 && nx<n) {
                    if (arr[ny][nx]==1) { // 지나갈 수 있는 곳(흰방)
                        if (!visited[ny][nx][level]) {
                            visited[ny][nx][level] = true;
                            q.add(new Pair(ny, nx, level));
                        }
                    } else { // 지나갈 수 없는 곳 (검은 방)
                        if (!visited[ny][nx][level+1]) {
                            visited[ny][nx][level+1] = true;
                            q.add(new Pair(ny, nx, level+1));
                        }
                    }
                }
            }

        }
        return -1;
    }
}