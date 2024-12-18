import java.util.*;
import java.io.*;

class Pair {
    int y, x, level;

    public Pair(int y, int x, int level) {
        this.y = y;
        this.x = x;
        this.level = level;
    }
}

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] distance;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        distance = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (distance[ny][nx] > curr.level + 1) {
                        distance[ny][nx] = curr.level + 1;
                        q.add(new Pair(ny, nx, curr.level + 1));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, distance[i][j]);
            }
        }

        System.out.println(result);
    }
}