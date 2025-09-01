import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] arr;
    static int[] dy = {-1, 0, 1};
    static int count = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0 ;i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][m];

        for (int i = 0 ;i<n; i++) {
            if (arr[i][0]!='x') {
                visited[i][0] = true;
                dfs(i, 0);
            }
        }

        System.out.println(count);
    }

    public static boolean dfs(int y, int x) {
        if (x==m-1) {
            count++;
            return true;
        }

        for (int d = 0; d<3; d++) {
            int ny = y+dy[d];
            int nx = x+1;
            if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
            if (arr[ny][nx]!='x' && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (dfs(ny, nx)) return true;
            }
        }
        return false;
    }
}