import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, k;
    static int[][] arr;
    static int[][] original;
    static boolean[] visited;
    static class Rotate {
        int y, x, s;

        public Rotate(int y, int x, int s) {
            this.y = y;
            this.x = x;
            this.s = s;
        }
    }
    static Rotate[] rotations;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        original = new int[n][m];
        visited = new boolean[k];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                original[i][j] = arr[i][j];
            }
        }

        rotations = new Rotate[k];

        for (int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            rotations[i] = new Rotate(y, x, s);
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void rotate(int sy, int sx, int ey, int ex) {
        int range = ey-sy;
        int[][] temp = new int[n][m];
        for (int i = 0; i<n; i++) {
            Arrays.fill(temp[i], -Integer.MAX_VALUE);
        }

        for (int i = 0; i<range/2; i++) {
            // 우측 이동
            for (int j = sx+i+1; j<=ex-i; j++) {
                temp[sy+i][j] = arr[sy+i][j-1];
            }

            // 하방 이동
            for (int j = sy+i+1; j<=ey-i; j++) {
                temp[j][ex-i] = arr[j-1][ex-i];
            }

            // 좌측 이동
            for (int j = ex-i-1; j>=sx+i; j--) {
                temp[ey-i][j] = arr[ey-i][j+1];
            }

            // 상방 이동
            for (int j = ey-i-1; j>=sy+i; j--) {
                temp[j][sx+i] = arr[j+1][sx+i];
            }
        }
        temp[sy+range/2][sx+range/2] = arr[sy+range/2][sx+range/2];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (temp[i][j]!=-Integer.MAX_VALUE) {
                    arr[i][j] = temp[i][j];
                }
            }
        }
    }

    public static void restoreArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = original[i][j];
            }
        }
    }

    public static int calculateMinRowSum() {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += arr[i][j];
            }
            minSum = Math.min(minSum, rowSum);
        }
        return minSum;
    }

    public static void dfs(int level) {

        if (level == k) {
            int currentMin = calculateMinRowSum();
            answer = Math.min(answer, currentMin);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Rotate a = rotations[i];
                int sy = a.y - a.s;
                int sx = a.x - a.s;
                int ey = a.y + a.s;
                int ex = a.x + a.s;

                int[][] tempArr = new int[n][m];
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        tempArr[r][c] = arr[r][c];
                    }
                }

                rotate(sy, sx, ey, ex);

                dfs(level + 1);

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        arr[r][c] = tempArr[r][c];
                    }
                }

                visited[i] = false;
            }
        }
    }
}