import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int count = 0;
    static boolean[] visited;
    static ArrayList<Integer> [] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        edgeList = new ArrayList[n+1];
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i<=n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edgeList[u].add(v);
            edgeList[v].add(u);
        }
        for (int i = 1; i<=n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int num) {
        visited[num] = true;
        for (int edge : edgeList[num]) {
            if (!visited[edge]) {
                visited[edge] = true;
                dfs(edge);
            }
        }
    }
}