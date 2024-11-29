import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y, x, breakCnt;

        public Pair(int y, int x, int breakCnt) {
            this.y = y;
            this.x = x;
            this.breakCnt = breakCnt;
        }
    }
    static int n, m;
    static int[][][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n][m][2];
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            String now = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = now.charAt(j) - '0';
            }
        }
        visited[0][0][0] = 1;
        System.out.println(bfs(0, 0));
    }
    public static int bfs(int y, int x) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int ay = curr.y;
            int ax = curr.x;
            int cnt = curr.breakCnt;

            if (ay==n-1 && ax==m-1) {
                return visited[ay][ax][cnt];
            }

            for (int i = 0; i<4; i++) {
                int ny = ay+dy[i];
                int nx = ax+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m) {
                    if (arr[ny][nx]==1 && cnt==0) {
                        visited[ny][nx][1] = visited[ay][ax][0] + 1;
                        q.add(new Pair(ny, nx, 1));
                    }
                    if (arr[ny][nx]==0 && visited[ny][nx][cnt]==0) {
                        visited[ny][nx][cnt] = visited[ay][ax][cnt] + 1;
                        q.add(new Pair(ny, nx, cnt));
                    }
                }
            }
        }

        return -1;
    }
}