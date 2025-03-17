import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] meltCnt;
    static boolean[][] visited;
    static int time = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            meltCnt = new int[n][m];
            visited = new boolean[n][m];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int y = curr[0];
                int x = curr[1];
                for (int i = 0; i<4; i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if (ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx]) {
                        if (arr[ny][nx]==0) {
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        } else if (arr[ny][nx]==1) {
                            meltCnt[ny][nx]++;
                        }
                    }
                }
            }

            int temp = 0;
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (arr[i][j]==1 && meltCnt[i][j]>=2) {
                        arr[i][j] = 0;
                    } else if (arr[i][j]==1) {
                        temp++;
                    }
                }
            }

            if (temp!=0) {
                time++;
            } else {
                break;
            }

        }
        System.out.println(time + 1);

    }
}