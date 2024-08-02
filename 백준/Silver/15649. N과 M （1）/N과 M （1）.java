import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new int[m];
        dfs(0, n, m);
    }

    public static void dfs(int level, int n, int m) {
        if (level==m) {
            for (int i = 0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i<n+1; i++) {
            if (!visited[i]) {
                arr[level] = i;
                visited[i] = true;
                dfs(level+1, n, m);
                arr[level] = 0;
                visited[i] = false;
            }
        }
    }
}