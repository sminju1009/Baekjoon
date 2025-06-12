import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dist = Integer.MAX_VALUE;
        int building1 = 0, building2 = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            Arrays.fill(arr[i], 987654321);
            arr[i][i] = 0;
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++){
                 for (int j = 0; j<n; j++) {
                     if (arr[i][j]>arr[i][k]+arr[k][j]) {
                         arr[i][j]=arr[i][k]+arr[k][j];
                     }
                 }
            }
        }

        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                int tempSum = 0;
                for (int k = 0; k<n; k++) {
                    int d = Math.min(arr[i][k], arr[k][j]);
                    tempSum += d;
                }
                if (dist>tempSum) {
                    dist = tempSum;
                    building1 = i+1;
                    building2 = j+1;
                }
            }
        }

        System.out.println(building1 + " " + building2 + " " + dist*2);

    }

}