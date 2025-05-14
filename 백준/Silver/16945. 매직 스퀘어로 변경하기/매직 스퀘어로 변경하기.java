import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited = new boolean[10];
    static int[][] arr = new int[3][3];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int cost) {
        if (level==9 && isMagicSquare()) {
            answer = Math.min(cost, answer);
            return;
        }

        int y = level/3;
        int x = level%3;

        for (int i = 1; i<10; i++) {
            if (!visited[i]) {
                int temp = arr[y][x];
                visited[i] = true;
                arr[y][x] = i;
                dfs(level+1, cost+Math.abs(temp-i));
                visited[i] = false;
                arr[y][x] = temp;
            }
        }
    }

    public static boolean isMagicSquare() {

        int row1 = arr[0][0] + arr[0][1] + arr[0][2];
        int row2 = arr[1][0] + arr[1][1] + arr[1][2];
        int row3 = arr[2][0] + arr[2][1] + arr[2][2];

        int col1 = arr[0][0] + arr[1][0] + arr[2][0];
        int col2 = arr[0][1] + arr[1][1] + arr[2][1];
        int col3 = arr[0][2] + arr[1][2] + arr[2][2];

        int cross1 = arr[0][0] + arr[1][1] + arr[2][2];
        int cross2 = arr[2][0] + arr[1][1] + arr[0][2];

        if (row1!=15 || row2!=15 || row3!=15) return false;
        if (col1!=15 || col2!=15 || col3!=15) return false;
        if (cross1!=15 || cross2!=15) return false;
        return true;
    }
}