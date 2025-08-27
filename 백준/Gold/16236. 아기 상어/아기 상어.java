import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;

    static class Fish {
        int y, x, dist;

        public Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static class Pair {
        int y, x, level;

        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static int fishSize = 2;   
    static int ateFish = 0;    
    static int answer = 0;     
    static int[] dy = {-1, 0, 0, 1}; 
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int sy = 0, sx = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sy = i;
                    sx = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs(sy, sx);
            if (target == null) break;

            answer += target.dist;
            sy = target.y;
            sx = target.x;

            arr[sy][sx] = 0;
            ateFish++;
            if (ateFish == fishSize) {
                fishSize++;
                ateFish = 0;
            }
        }

        System.out.println(answer);
    }

    public static Fish bfs(int sy, int sx) {
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx, 0));
        visited[sy][sx] = true;

        List<Fish> candidates = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] > fishSize) continue;

                visited[ny][nx] = true;
                q.add(new Pair(ny, nx, level + 1));

                if (arr[ny][nx] > 0 && arr[ny][nx] < fishSize) {
                    candidates.add(new Fish(ny, nx, level + 1));
                }
            }
        }

        if (candidates.isEmpty()) return null;

        candidates.sort((f1, f2) -> {
            if (f1.dist != f2.dist) return f1.dist - f2.dist;
            if (f1.y != f2.y) return f1.y - f2.y;
            return f1.x - f2.x;
        });

        return candidates.get(0);
    }
}