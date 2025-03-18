import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] arr;
    static int[][] visited;
    static Queue<int[]> jq;
    static Queue<int[]> fq;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        jq = new LinkedList<>();
        fq = new LinkedList<>();
        visited = new int[n][m];

        for (int i = 0; i<n; i++) {
            String line = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j]=='J') {
                    arr[i][j] = '.';
                    jq.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
                if (arr[i][j]=='F') {
                    fq.add(new int[]{i, j});
                }
            }
        }

        int result = bfs();
        System.out.println((result!=-1) ? result : "IMPOSSIBLE");

    }

    public static int bfs() {
        while (!jq.isEmpty()) {
            int fireSize = fq.size();
            for (int i = 0; i<fireSize; i++) {
                int[] curr = fq.poll();
                int y = curr[0];
                int x = curr[1];

                for (int d = 0; d<4; d++) {
                    int ny = y+dy[d];
                    int nx = x+dx[d];
                    if (ny>=0 && ny<n && nx>=0 && nx<m && arr[ny][nx]=='.' && visited[ny][nx]==0) {
                        arr[ny][nx] = 'F';
                        fq.add(new int[]{ny, nx});
                    }
                }
            }

            int jhSize = jq.size();
            for (int i = 0; i<jhSize; i++) {
                int[] curr = jq.poll();
                int y = curr[0];
                int x = curr[1];

                for (int d = 0; d<4; d++) {
                    int ny = y+dy[d];
                    int nx = x+dx[d];

                    if (ny>=n || ny<0 || nx>=m || nx<0) {
                        return visited[y][x];
                    }

                    if (arr[ny][nx]=='.' && visited[ny][nx]==0) {
                        visited[ny][nx] = visited[y][x] + 1;
                        jq.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return -1;
    }

}