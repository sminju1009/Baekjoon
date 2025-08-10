import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dist = new int[n][n];
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (i==j) continue;
                    dist[i][j] = 987654321;
                }
            }
            for (int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                dist[a][b] = Math.min(dist[a][b], c);
                dist[b][a] = Math.min(dist[b][a], c);
            }
            for (int k = 0; k<n; k++) {
                for (int i = 0; i<n; i++) {
                    for (int j = 0; j<n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
            int p = Integer.parseInt(br.readLine());
            int[] person = new int[p];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<p; i++) {
                person[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            int distance = Integer.MAX_VALUE;
            int roomNumber = 0;
            int count = 0;
            
            for (int i = 0; i<n; i++) {
                int temp = 0;
                for (int j = 0; j<p; j++) {
                    temp += dist[person[j]][i]; 
                }
                if (distance>temp) {
                    distance = temp;
                    roomNumber = count;
                }
                count++;
            }
            sb.append((roomNumber+1) + "\n");
        }
        System.out.println(sb);
    }
}