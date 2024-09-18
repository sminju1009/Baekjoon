import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];
        parents = new int[n+1];
        for(int i = 1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);
        for (int i = 2; i<=n; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int level) {
        visited[level] = true;
        for (int i: arr[level]) {
            if (!visited[i]) {
                parents[i] = level;
                dfs(i);
            }
        }
    }
}