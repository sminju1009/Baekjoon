import java.util.*;
import java.io.*;

public class Main {
    static int r, c, k;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i<r; i++) {
            String temp = br.readLine();
            for (int j = 0; j<c; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        visited[r-1][0] = true;
        dfs(1, r-1, 0);
        System.out.println(answer);
    }

    // 현수 현재 위치는 왼쪽 아래(r-1, 0), 집은 오른쪽 위(0, c-1)
    public static void dfs(int level, int y, int x) {
        if (level==k) {
            if (y==0 && x==c-1) {
                answer++;
            } else {
                return;
            }
        }

        for (int i = 0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if (ny>=0 && ny<r && nx>=0 && nx<c && !visited[ny][nx] && arr[ny][nx]!='T') {
                visited[ny][nx] = true;
                dfs(level+1, ny, nx);
                visited[ny][nx] = false;
            }
        }
    }
}