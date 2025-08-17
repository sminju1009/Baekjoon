import java.util.*;
import java.io.*;

public class Main {
    
    static int INF = 987654321;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] point = new int[n][n];

        for (int i = 0; i<n; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                point[i][j] = j;
            }
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b], c);
            arr[b][a] = Math.min(arr[b][a], c);
        }

        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][j]>arr[i][k]+arr[k][j]) {
                        arr[i][j] = arr[i][k]+arr[k][j];
                        point[i][j] = point[i][k];
                    }
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (i==j) {
                    System.out.print("- ");
                } else {
                    System.out.print(point[i][j]+1 + " ");
                }
            }
            System.out.println();
        }
    }
}