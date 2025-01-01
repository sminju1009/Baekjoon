import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int n;
    static int[][] arr;
    static int maxHeight = 0;
    static int safeArea = 0; // 물에 잠기지 않는 안전한 영역의 갯수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        for (int h = 0; h<=maxHeight; h++) {
            int area = 0;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][j]>h && !visited[i][j]) {
                        area += bfs(h, visited, i, j);
                    }
                }
            }
            safeArea = Math.max(area, safeArea);
        }
        System.out.println(safeArea);
    }

    public static int bfs(int height, boolean[][] visited, int y, int x) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i<4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<n && !visited[ny][nx] && arr[ny][nx]>height) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx));
                }
            }
        }
        return 1;
    }
}