import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int h, w;
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w==0 && h==0) {
                break;
            }
            arr = new int[h][w];
            for (int i = 0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[h][w];
            int count = 0;

            q = new LinkedList<>();
            for (int i = 0; i<h; i++) {
                for (int j = 0; j<w; j++) {
                    if (arr[i][j]==1 && !visited[i][j]) {
                        visited[i][j] = true;
                        count += bfs(i, j);
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int ay, int ax) {
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        q.add(new Pair(ay, ax));


        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            for (int i = 0; i<8; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<h && nx>=0 && nx<w && !visited[ny][nx] && arr[ny][nx]==1) {
                    visited[ny][nx]=true;
                    q.add(new Pair(ny, nx));
                }
            }
        }

        return 1;
    }
}