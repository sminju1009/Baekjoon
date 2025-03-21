import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[n][m][k+1];
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int wall = curr[2];

            if (y==n-1 && x==m-1) {
                return visited[y][x][wall];
            }

            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m) {
                    if (arr[ny][nx]==1 && wall<k) {
                        if (visited[ny][nx][wall+1] == 0) {
                            visited[ny][nx][wall+1] = visited[y][x][wall] + 1;
                            q.add(new int[]{ny, nx, wall+1});
                        }
                    }
                    if (arr[ny][nx]==0 && visited[ny][nx][wall]==0) {
                        visited[ny][nx][wall] = visited[y][x][wall] + 1;
                        q.add(new int[]{ny, nx, wall});
                    }
                }
            }
        }

        return -1;
    }
}