import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    if (bfs(i, j)) count++;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        boolean isPeak = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1];

            for (int d = 0; d<8; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (arr[ny][nx] > arr[y][x]) isPeak = false;
                if (!visited[ny][nx] && arr[ny][nx] == arr[y][x]) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return isPeak;
    }
}