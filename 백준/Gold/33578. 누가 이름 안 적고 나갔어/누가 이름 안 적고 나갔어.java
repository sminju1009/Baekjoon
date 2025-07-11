import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static char[][] arr;
    static int n, m;
    static boolean[][][] visited;

    static class Pair implements Comparable<Pair> {
        int y, x, level;
        boolean teacher;

        public Pair(int y, int x, int level, boolean teacher) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.teacher = teacher;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.level, other.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m][2];
        int sy = 0, sx = 0, ey = 0, ex = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') {
                    ey = i;
                    ex = j;
                }
                if (arr[i][j] == 'J') {
                    sy = i;
                    sx = j;
                }
            }
        }

        System.out.println(bfs(sy, sx, ey, ex));
    }

    public static int bfs(int sy, int sx, int ey, int ex) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(sy, sx, 0, false));
        visited[sy][sx][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, level = curr.level;
            boolean teacher = curr.teacher;

            if (y == ey && x == ex) {
                return level;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (arr[ny][nx] != '#') {
                        int teacherState = teacher ? 1 : 0;

                        if (!visited[ny][nx][teacherState]) {
                            visited[ny][nx][teacherState] = true;

                            if (!teacher && arr[ny][nx] == 'T') {
                                q.add(new Pair(ny, nx, level + 2, true));
                            } else {
                                q.add(new Pair(ny, nx, level + (teacher ? 1 : 2), teacher));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}