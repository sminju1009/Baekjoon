import java.util.*;
import java.io.*;

public class Main {

    static double[] dir = new double[4];
    static int n;
    static double answer = 0;
    static boolean[][] visited = new boolean[31][31];
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i<4; i++) {
            dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        dfs(0, 15, 15, 1);

        System.out.println(answer);

    }

    public static void dfs(int level, int y, int x, double result) {
        if (level==n) {
            answer += result;
            return;
        }

        for (int d = 0; d<4; d++) {
            if (dir[d]==0) continue;
            int ny = y+dy[d];
            int nx = x+dx[d];
            if (ny<0 || ny>30 || nx<0 || nx>30) continue;
            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(level+1, ny, nx, result * dir[d]);
                visited[ny][nx] = false;
            }
        }
    }
}