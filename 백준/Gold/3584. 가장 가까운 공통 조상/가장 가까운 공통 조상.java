import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            parents = new int[n];
            visited = new boolean[n];
            Arrays.fill(parents, -1);
            for (int i = 0; i<n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                parents[b] = a;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            findParent(node1, node2);
        }
    }

    public static void findParent(int node1, int node2) {
        while (node1>=0) {
            visited[node1] = true;
            node1 = parents[node1];
        }
        while (node2>=0) {
            if (visited[node2]) {
                System.out.println(node2 + 1);
                break;
            }
            node2 = parents[node2];
        }
    }
}