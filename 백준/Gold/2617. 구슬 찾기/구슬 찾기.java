import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> heavier = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> lighter = new ArrayList<>();
    static boolean[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            heavier.add(new ArrayList<>());  
            lighter.add(new ArrayList<>());  
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            heavier.get(b).add(a); 
            lighter.get(a).add(b);
        }

        int mid = (n + 1) / 2;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int heavyCount = dfs(heavier, i);

            visited = new boolean[n + 1];
            int lightCount = dfs(lighter, i);

            if (heavyCount >= mid || lightCount >= mid) cnt++;
        }

        System.out.println(cnt);
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int start) {
        int count = 0;
        visited[start] = true;
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                count += 1 + dfs(graph, next);
            }
        }
        return count;
    }
}