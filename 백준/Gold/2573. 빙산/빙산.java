import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visited;

    static int n, m;
    static int[][] arr;
    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

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

        int time = 1;

        while (true) {
            int[][] result = melt(arr.clone()); // 빙산 녹이기
            arr = result;
            int land = 0; // 녹고 나서 땅의 갯수 세기
            visited = new boolean[n][m];
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (arr[i][j]!=0 && !visited[i][j]) {
                        land += bfs(i, j);
                    }
                }
            }
            if (land==0) {
                System.out.println(0);
                break;
            }

            if (land>1) {
                System.out.println(time);
                break;
            }

            time++;
        }
    }

    // bfs 실행 전 visited 초기갱신 해줘야 함
    public static int bfs(int sy, int sx) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i<4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx] && arr[ny][nx]!=0) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx));
                }
            }
        }
        return 1;
    }

    // 빙산 녹이기 진행
    public static int[][] melt(int[][] now) {
        int[][] result = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (now[i][j]!=0) {
                    int temp = 0;
                    for (int d = 0; d<4; d++) {
                        int ny = i+dy[d];
                        int nx = j+dx[d];
                        if (ny>=0 && ny<n && nx>=0 && nx<m && arr[ny][nx]==0) {
                            temp++;
                        }
                    }
                    result[i][j] = Math.max(0, now[i][j]-temp);
                }
            }
        }
        return result;
    }
}