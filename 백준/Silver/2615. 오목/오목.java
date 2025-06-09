import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr = new int[19][19];
    static int[] dy = {0, 1, 1, -1};
    static int[] dx = {1, 0, 1, 1};
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i<19; i++) {
            for (int j = 0; j<19; j++) {
                if (arr[i][j]!=0 && !finished) {
                    for (int d = 0; d<4; d++) {
                        if (isWin(i, j, d)) {
                            finished = true;
                            System.out.println(arr[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                        }
                    }
                }
            }
        }
        if (!finished) System.out.println(0);

    }

    public static boolean isWin(int y, int x, int dir) {
        int py = y-dy[dir];
        int px = x-dx[dir];
        if (py>=0 && py<19 && px>=0 && px<19 && arr[py][px]==arr[y][x]) {
            return false;
        }

        int count = 1;

        int ny = y+dy[dir];
        int nx = x+dx[dir];
        while (ny>=0 && ny<19 && nx>=0 && nx<19 && arr[y][x]==arr[ny][nx]) {
            ny += dy[dir];
            nx += dx[dir];
            count++;
        }

        return count==5;
    }

}