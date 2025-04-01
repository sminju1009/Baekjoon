import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static class Pair {
        int y;
        int x;
        int cnt;
        int dist;

        public Pair(int y, int x, int cnt, int dist) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
    static int h, w;
    static int move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        move = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        for (int i = 0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[h][w][move+1];
        int[] dy = {0, 1, 0, -1, -1, -2, -2, -1, 2, 1, 2, 1};
        int[] dx = {1, 0, -1, 0, -2, -1, 1, 2, 1, 2, -1, -2};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, move, 0));
        visited[0][0][move] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            int cnt = curr.cnt;
            int dist = curr.dist;

            if (y==h-1 && x==w-1) {
                return dist;
            }

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<h && nx>=0 && nx<w && !visited[ny][nx][cnt] && arr[ny][nx]==0) {
                    visited[ny][nx][cnt] = true;
                    q.add(new Pair(ny, nx, cnt, dist+1));
                }
            }

            if (cnt>0) {
                for (int i = 4; i<12; i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if (ny>=0 && ny<h && nx>=0 && nx<w && !visited[ny][nx][cnt-1] && arr[ny][nx]==0) {
                        visited[ny][nx][cnt-1] = true;
                        q.add(new Pair(ny, nx, cnt-1, dist+1));
                    }
                }
            }
        }

        return -1;
    }
}