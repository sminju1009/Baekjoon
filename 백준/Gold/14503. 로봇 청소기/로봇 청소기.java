import java.util.*;
import java.io.*;

public class Main {
    static int n, m;

    // 북, 동, 남, 서 순
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sdir = Integer.parseInt(st.nextToken());
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(sy, sx, sdir);
        System.out.println(count);
    }

    public static void clean(int y, int x, int dir) {
        if (arr[y][x] == 0) {
            arr[y][x] = 2; 
            count++;
        }
        
        boolean hasCleanableArea = false;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 0) {
                hasCleanableArea = true;
                break;
            }
        }

        if (!hasCleanableArea) {
            int backDir = (dir + 2) % 4;
            int by = y + dy[backDir];
            int bx = x + dx[backDir];
            
            if (by >= 0 && by < n && bx >= 0 && bx < m && arr[by][bx] != 1) {
                clean(by, bx, dir);
            }
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; 
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 0) {
                    clean(ny, nx, dir);
                    return;
                }
            }
        }
    }
}