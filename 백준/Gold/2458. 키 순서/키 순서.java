import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = true; 
        }

        for (int k = 0; k < n; k++) { 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) { 
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int known = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] || graph[j][i]) { 
                    known++;
                }
            }
            if (known == n - 1) count++; 
        }

        System.out.println(count);
    }
}