import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i<n; i++ ){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][j]>arr[i][k]+arr[k][j]) {
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            if (arr[s][e]<=d) {
                sb.append("Enjoy other party\n");
            } else {
                sb.append("Stay here\n");
            }
        }

        System.out.println(sb);
    }
}