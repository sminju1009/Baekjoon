import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 오름차순 정렬
        }
    }

    static int n, m, x;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            int[] go = dijkstra(i); // i에서 다른 노드까지
            int[] back = dijkstra(x); // x에서 다른 노드까지
            maxTime = Math.max(maxTime, go[x] + back[i]);
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currNode = curr.end;
            int currCost = curr.cost;

            if (currCost > dist[currNode]) {
                continue;
            }

            for (Node neighbor : graph.get(currNode)) {
                int nextNode = neighbor.end;
                int nextCost = currCost + neighbor.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }

        return dist;
    }
}