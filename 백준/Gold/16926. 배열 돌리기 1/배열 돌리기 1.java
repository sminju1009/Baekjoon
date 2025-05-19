import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-->0) {
            rotate();
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void rotate() {
        int count = Math.min(n, m) / 2;
        for (int i = 0; i < count; i++) {

            int temp = arr[i][i];

            for (int j = i; j < m -1-i; j++) {
                arr[i][j] = arr[i][j+1];
            }

            for (int j = i; j < n-1-i; j++) {
                arr[j][m-1-i] = arr[j+1][m-1-i];
            }

            for (int j = m-1-i; j > i; j--) {
                arr[n-1-i][j] = arr[n-1-i][j-1];
            }

            for (int j = n-1-i; j > i+1; j--) {
                arr[j][i] = arr[j-1][i];
            }

            arr[i+1][i] = temp;
        }
    }
}