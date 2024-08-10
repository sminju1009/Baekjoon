import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n;
    static int blue = 0; // 파란 색종이 갯수(1)
    static int white = 0; // 흰색 색종이 갯수(0)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void partition(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            if (arr[row][col]==0) {
                white++;
            } else{
                blue++;
            }
            return;
        }

        int newSize = size/2;

        partition(row, col, newSize);
        partition(row+newSize, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row+newSize, col+newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];
        for (int i = row; i<row+size; i++) {
            for (int j = col; j<col+size; j++) {
                if (arr[i][j]!=color) {
                    return false;
                }
            }
        }
        return true;
    }
}