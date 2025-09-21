import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static char[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i<n; i++){
            String str = br.readLine();
            for (int j = 0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j+1 < n) {
                    swap(i, j, i, j+1);
                    answer = Math.max(answer, check());
                    swap(i, j, i, j+1);
                }
                if (i+1 < n) {
                    swap(i, j, i+1, j);
                    answer = Math.max(answer, check());
                    swap(i, j, i+1, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void swap(int y1, int x1, int y2, int x2) {
        char temp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = temp;
    }

    public static int check() {
        int max = 1;

        for (int i=0; i<n; i++) {
            int cnt = 1;
            for (int j=1; j<n; j++) {
                if (arr[i][j] == arr[i][j-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int j=0; j<n; j++) {
            int cnt = 1;
            for (int i=1; i<n; i++) {
                if (arr[i][j] == arr[i-1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}