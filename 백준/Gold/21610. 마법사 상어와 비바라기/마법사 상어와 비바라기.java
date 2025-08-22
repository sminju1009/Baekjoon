import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] crossY = {-1, -1, 1, 1};
    static int[] crossX = {-1, 1, -1, 1};
    static int n, m;
    static int[][] arr;
    static Queue<Pair> clouds = new LinkedList<>();
    static boolean[][] wasCloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름 초기상태 저장
        clouds.add(new Pair(n-1, 0));
        clouds.add(new Pair(n-1, 1));
        clouds.add(new Pair(n-2, 0));
        clouds.add(new Pair(n-2, 1));

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            s = s%n;

            // 구름 이동하기
            int size = clouds.size();
            for (int j = 0; j<size; j++) {
                Pair curr = clouds.poll();
                int y = curr.y, x = curr.x;
                Pair now = move(y, x, dir, s);
                clouds.add(now);
            }

            // 구름 있는 칸에 비가 내리고 구름 사라짐
            size = clouds.size();
            for (int j = 0; j<size; j++) {
                Pair curr = clouds.poll();
                int y = curr.y, x = curr.x;
                arr[y][x]++;
                clouds.add(new Pair(y, x));
            }

            // 현재 구름에서 대각선 방향에 물이 있는가
            wasCloud = new boolean[n][n]; // 과거 구름이었던 곳 저장 -> 새 구름 형성 시 구름이 되어서는 안 됨.
            while (!clouds.isEmpty()) {
                Pair curr = clouds.poll();
                int y = curr.y, x = curr.x;
                int count = 0;
                for (int d = 0; d<4; d++) {
                    int ny = y+crossY[d], nx = x+crossX[d];
                    if (isInRange(ny, nx)  && arr[ny][nx] > 0) count++;
                }
                arr[y][x] += count;
                wasCloud[y][x] = true;
            }
            
            // 새 구름 형성
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<n; k++) {
                    if (arr[j][k]>=2 && !wasCloud[j][k]) {
                        clouds.add(new Pair(j, k));
                        arr[j][k] -= 2;
                    }
                }
            }

        }

        int answer = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }

    public static Pair move(int y, int x, int dir, int s) {
        int ny = (y + dy[dir] * s) % n;
        int nx = (x + dx[dir] * s) % n;
        if (ny < 0) ny += n;
        if (nx < 0) nx += n;
        return new Pair(ny, nx);
    }

    public static boolean isInRange(int y, int x) {
        if (y<0 || y>=n || x<0 || x>=n) return false;
        return true;
    }
}