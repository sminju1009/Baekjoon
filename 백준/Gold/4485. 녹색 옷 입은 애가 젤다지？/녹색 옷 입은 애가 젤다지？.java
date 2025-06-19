import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int INF = 987654321;
    static int n;
    static int[][] arr;
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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while (true) {
            tc++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            arr = new int[n][n];
            for (int i = 0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem " + tc + ": " + dijkstra() + "\n");
        }
        System.out.println(sb);
    }

    public static int dijkstra() {
        PriorityQueue<Pair> q = new PriorityQueue<>();

        int[][] di = new int[n][n];
        for (int i = 0; i<n; i++) {
            Arrays.fill(di[i], INF);
        }

        q.add(new Pair(0, 0, arr[0][0]));
        di[0][0] = arr[0][0];

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;
            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<n && di[ny][nx]>di[y][x]+arr[ny][nx]) {
                    di[ny][nx] = di[y][x] + arr[ny][nx];
                    q.add(new Pair(ny, nx, di[ny][nx]));
                }
            }

        }

        return di[n-1][n-1];
    }
}