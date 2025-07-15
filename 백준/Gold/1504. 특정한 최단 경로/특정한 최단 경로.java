import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int INF = 200000000;
    static List<Node>[] list;
    static int[] dist;
    static int n, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    public static int dijkstra(int start, int end) {
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int cur = curr.end;

            if (check[cur]) continue;
            check[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        
        return dist[end];
    }
}