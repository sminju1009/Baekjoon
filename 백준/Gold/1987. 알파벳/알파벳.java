import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int maxCnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxCnt);
    }

    public static void dfs(int y, int x, int cnt) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        maxCnt = Math.max(maxCnt, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                int currentAlphabet = arr[ny][nx] - 'A';
                if (!visited[currentAlphabet]) {
                    visited[currentAlphabet] = true;
                    dfs(ny, nx, cnt + 1);
                    visited[currentAlphabet] = false;
                }
            }
        }
    }
}