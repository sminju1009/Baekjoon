import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
public class Main {
    static int INF = Integer.MAX_VALUE;
    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v+1];
        dist = new int[v+1];
        Arrays.fill(dist, INF);

        for (int i = 1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(k);
        for (int i = 1; i<=v; i++) {
            if (dist[i]==INF) sb.append("INF" + "\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[v+1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int cur = curr.end;

            if (check[cur] == true) continue;
            check[cur] = true;

            for (Node node: list[cur]) {
                if (dist[node.end]>dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}