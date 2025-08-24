import java.util.*;
import java.io.*;

public class Main {

    static final int[] percent = {5, 10, 10, 7, 7, 2, 2, 1, 1};
    // 각 방향별 모래가 퍼지는 상대 좌표 (y, x)
    // 순서: 5%, 10%, 10%, 7%, 7%, 2%, 2%, 1%, 1%, a 순
    // dir 0: left
    static int[] dyLeft = {0, -1, 1, -1, 1, -2, 2, -1, 1, 0};
    static int[] dxLeft = {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1};
    // dir 1: down
    static int[] dyDown = {2, 1, 1, 0, 0, 0, 0, -1, -1, 1};
    static int[] dxDown = {0, -1, 1, -1, 1, -2, 2, -1, 1, 0};
    // dir 2: right
    static int[] dyRight = {0, -1, 1, -1, 1, -2, 2, -1, 1, 0};
    static int[] dxRight = {2, 1, 1, 0, 0, 0, 0, -1, -1, 1};
    // dir 3: up
    static int[] dyUp = {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1};
    static int[] dxUp = { 0, -1,  1,-1, 1,-2, 2,-1, 1,  0};

    static int[][] dys = {dyLeft, dyDown, dyRight, dyUp};
    static int[][] dxs = {dxLeft, dxDown, dxRight, dxUp};
    static int[] moveDy = {0, 1, 0, -1};
    static int[] moveDx = {-1, 0, 1, 0};
    static int outSand = 0;
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0 ;i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveTornado();

        System.out.println(outSand);

    }

    public static void moveTornado () {
        int count = 1;
        int y = n/2, x = n/2;

        int dir = 0;
        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < count; j++) {
                    if (y==0 && x==0) return;

                    y += moveDy[dir];
                    x += moveDx[dir];
                    if (arr[y][x] > 0) {
                        spreadSand(y, x, dir);
                    }
                }
                dir = (dir+1) % 4;
            }
            count++;
        }
    }

    public static void spreadSand(int y, int x, int dir) {
        int orgSand = arr[y][x];
        int sandSum = 0;

        for (int i = 0; i<9; i++) {
            int ny = y+dys[dir][i];
            int nx = x+dxs[dir][i];
            int spreadSand = (orgSand * percent[i])/100;

            if (spreadSand>0) {
                if (ny<0 || ny>=n || nx<0 || nx>=n) {
                    outSand += spreadSand;
                } else {
                    arr[ny][nx] += spreadSand;
                }
                sandSum += spreadSand;
            }
        }

        int ay = y + dys[dir][9];
        int ax = x + dxs[dir][9];
        int alphaSand = orgSand - sandSum;

        if (alphaSand>0) {
            if (ay<0 || ay>=n || ax<0 || ax>=n) {
                outSand += alphaSand;
            } else {
                arr[ay][ax] += alphaSand;
            }
        }

        arr[y][x] = 0;
    }

}