import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int loops = Math.min(n, m) / 2;

        for (int i = 0; i < loops; i++) {
            int top = i;
            int bottom = n-i-1;
            int left = i;
            int right = m-i-1;

            int len = 2 * (bottom - top) + 2 * (right - left);
            int rotate = r % len;

            for (int k = 0; k < rotate; k++) {
                int now = arr[top][left]; 
                
                for (int j = left; j < right; j++) {
                    arr[top][j] = arr[top][j+1];
                }

                for (int j = top; j < bottom; j++) {
                    arr[j][right] = arr[j+1][right];
                }

                for (int j = right; j > left; j--) {
                    arr[bottom][j] = arr[bottom][j-1];
                }

                for (int j = bottom; j > top+1; j--) {
                    arr[j][left] = arr[j-1][left];
                }

                arr[top + 1][left] = now;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}