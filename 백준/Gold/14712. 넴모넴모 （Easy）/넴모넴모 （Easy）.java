import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int start) {
        answer += isSquare(level) ? 1 : 0;

        if (level==n*m) {
            return;
        }
        for (int i = start; i<n*m; i++) {
            int r = i/m;
            int c = i%m;
            if (!visited[r][c]) {
                visited[r][c] = true;
                dfs(level+1, i+1);
                visited[r][c] = false;
            }
        }
    }

    public static boolean isSquare(int level) {
        // 4칸 이하로 채워져 있는 경우는 애초에 없앨 수 없음
        if (level<4) return true;

        for (int i = 0; i<n-1; i++) {
            for (int j = 0; j<m-1; j++) {
                if (visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                    return false;
                }
            }
        }

        return true;
    }
}