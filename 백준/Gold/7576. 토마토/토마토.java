import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int y, x, level;

        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int maxLevel;
    static Queue<Pair> q = new LinkedList<>();
    // 문제 제출 전에 지워야 함

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        // 토마토가 다 익은 경우 1이고 이때는 bfs 돌리지 말고 0 출력
        int flag = 1;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j] == 0) {
                    flag = 0; // 안 익은 토마토가 있다
                    break;
                }
            }
        }
        if (flag == 1) {
            System.out.println(0);
        } else {
            // bfs 다 돌리기
            int[] dy = {0, 1, 0, -1};
            int[] dx = {1, 0, -1, 0};

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                int y = curr.y, x = curr.x, level = curr.level;

                for (int i = 0; i<4; i++) {
                    int newY = y+dy[i];
                    int newX = x+dx[i];
                    if (newY>=0 && newY<n && newX>=0 && newX<m && arr[newY][newX]==0 && !visited[newY][newX]) {
                        level++;
                        visited[newY][newX] = true;
                        arr[newY][newX] = 1;
                        q.add(new Pair(newY, newX, level));
                        maxLevel = Math.max(maxLevel, level);
                        level--;
                    }
                }
            }
            int available = 0;
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (arr[i][j] == 0) {
                        available = -1;
                        break;
                    }
                }
            }
            if (available == -1) {
                System.out.println(-1);
            } else {
                System.out.println(maxLevel);
            }
        }
    }
}