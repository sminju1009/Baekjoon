import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> higher; 
    static ArrayList<ArrayList<Integer>> lower;  
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        
        higher = new ArrayList<>();
        lower = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            higher.add(new ArrayList<>());
            lower.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            lower.get(a).add(b);   
            higher.get(b).add(a); 
        }

        visited = new boolean[n];
        int lowerCount = dfsCount(x, lower) - 1; 
        
        visited = new boolean[n];
        int higherCount = dfsCount(x, higher) - 1; 
        
        int bestRank = higherCount + 1;
        int worstRank = n - lowerCount;
        
        System.out.println(bestRank + " " + worstRank);
    }

    public static int dfsCount(int node, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        int count = 1;
        
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfsCount(next, graph);
            }
        }
        
        return count;
    }
}