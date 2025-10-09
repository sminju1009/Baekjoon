import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n, m, k;
    static int[][] arr;
    static boolean[][][][] visited; // n, m, afternoon, drill 순
    
    static class Pair{
        int y, x, level, afternoon, drill;

        public Pair (int y, int x, int level, int afternoon, int drill) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.afternoon = afternoon;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m][2][k+1];

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1, 0, 0));
        visited[0][0][0][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.y == n-1 && curr.x == m-1) {
                return curr.level;
            }

            int nextAfternoon = (curr.afternoon + 1) % 2;

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];
                
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                // 빈 칸인 경우
                if (arr[ny][nx] == 0) {
                    if (!visited[ny][nx][nextAfternoon][curr.drill]) {
                        visited[ny][nx][nextAfternoon][curr.drill] = true;
                        q.add(new Pair(ny, nx, curr.level + 1, nextAfternoon, curr.drill));
                    }
                } 
                // 벽인 경우
                else {
                    if (curr.drill < k) {
                        // 낮이면 벽을 부수고 이동
                        if (curr.afternoon == 0) {
                            if (!visited[ny][nx][nextAfternoon][curr.drill + 1]) {
                                visited[ny][nx][nextAfternoon][curr.drill + 1] = true;
                                q.add(new Pair(ny, nx, curr.level + 1, nextAfternoon, curr.drill + 1));
                            }
                        } 
                        // 밤이면 제자리에서 대기
                        else {
                            if (!visited[curr.y][curr.x][nextAfternoon][curr.drill]) {
                                visited[curr.y][curr.x][nextAfternoon][curr.drill] = true;
                                q.add(new Pair(curr.y, curr.x, curr.level + 1, nextAfternoon, curr.drill));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}