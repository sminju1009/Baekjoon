import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr = new char[5][9];
    static boolean[] visited = new boolean[12];
    static int[][] dots = {{0, 4}, {1, 1}, {1, 3}, {1, 5}, {1, 7},
            {2, 2}, {2, 6}, {3, 1}, {3, 3}, {3, 5}, {3, 7}, {4, 4}};
    static boolean found = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] != 'x' && arr[i][j] != '.') {
                    visited[arr[i][j] - 'A'] = true;
                }
            }
        }
        dfs(0);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int level) {
        if (found) return;

        if (level == 12) {
            if (check()) {
                found = true;
            }
            return;
        }

        int y = dots[level][0], x = dots[level][1];
        if (arr[y][x] == 'x') {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[y][x] = (char) (i + 'A');
                    dfs(level + 1);
                    if (found) return;
                    arr[y][x] = 'x';
                    visited[i] = false;
                }
            }
        } else {
            dfs(level + 1);
        }
    }

    public static boolean check() {
        if ((arr[0][4] - 'A') + (arr[1][3] - 'A') + (arr[2][2] - 'A') + (arr[3][1] - 'A') != 22) return false;
        if ((arr[3][1] - 'A') + (arr[3][3] - 'A') + (arr[3][5] - 'A') + (arr[3][7] - 'A') != 22) return false;
        if ((arr[3][7] - 'A') + (arr[2][6] - 'A') + (arr[1][5] - 'A') + (arr[0][4] - 'A') != 22) return false;
        if ((arr[1][1] - 'A') + (arr[1][3] - 'A') + (arr[1][5] - 'A') + (arr[1][7] - 'A') != 22) return false;
        if ((arr[1][1] - 'A') + (arr[2][2] - 'A') + (arr[3][3] - 'A') + (arr[4][4] - 'A') != 22) return false;
        if ((arr[4][4] - 'A') + (arr[3][5] - 'A') + (arr[2][6] - 'A') + (arr[1][7] - 'A') != 22) return false;

        return true;
    }
}