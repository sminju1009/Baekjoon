import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static ArrayList<Integer[]> graph[];
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[parent].add(new Integer[] {child, weight});
            graph[child].add(new Integer[] {parent, weight});
        }

        for (int i = 1; i<graph.length; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int node, int sum) {

        visited[node] = true;
        max = Math.max(sum, max);

        for (Integer[] temp: graph[node]) {
            if (!visited[temp[0]]) {
                dfs(temp[0], sum+temp[1]);
            }
        }
    }
}