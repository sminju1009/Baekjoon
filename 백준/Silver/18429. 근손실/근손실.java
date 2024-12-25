import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 500);
        System.out.println(count);
    }

    public static void dfs(int level, int weight) {
        if (weight<500) {
            return;
        }
        if (level==n) {
            if (weight>=500) count++;
            return;
        }
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level+1, weight+arr[i]-k);
                visited[i] = false;
            }
        }
    }
}