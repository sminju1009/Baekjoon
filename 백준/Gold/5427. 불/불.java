import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static char[][] arr;
    static int[][] visited;
    static Queue<int[]> fireQ;
    static Queue<int[]> sgQ;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            fireQ = new LinkedList<>();
            sgQ = new LinkedList<>();
            visited = new int[h][w];

            int sy = 0, sx = 0;
            for (int i = 0; i<h; i++) {
                String line = br.readLine();
                for (int j = 0; j<w; j++) {
                    arr[i][j] = line.charAt(j);
                    if (arr[i][j]=='@') {
                        sy = i;
                        sx = j;
                        arr[i][j] = '.';
                        sgQ.add(new int[]{sy, sx});
                        visited[sy][sx] = 1;
                    }
                    if (arr[i][j]=='*') {
                        fireQ.add(new int[]{i, j});
                    }
                }
            }

            int result = bfs();
            if (result != -1) {
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static int bfs() {
        while (!sgQ.isEmpty()) {
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                int[] curr = fireQ.poll();
                int y = curr[0], x = curr[1];

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d], nx = x + dx[d];
                    if (ny >= 0 && ny < h && nx >= 0 && nx < w && arr[ny][nx] == '.') {
                        arr[ny][nx] = '*';
                        fireQ.add(new int[]{ny, nx});
                    }
                }
            }

            int sgSize = sgQ.size();
            for (int i = 0; i < sgSize; i++) {
                int[] curr = sgQ.poll();
                int ay = curr[0], ax = curr[1];

                for (int d = 0; d < 4; d++) {
                    int ny = ay + dy[d], nx = ax + dx[d];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        return visited[ay][ax];
                    }

                    if (arr[ny][nx] == '.' && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[ay][ax] + 1;
                        sgQ.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return -1;
    }
}