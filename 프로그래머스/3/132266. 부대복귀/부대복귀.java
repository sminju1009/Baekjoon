import java.util.*;

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

class Solution {
    static int INF = 987654321;
    static List<Node>[] list;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            list[roads[i][0]].add(new Node(roads[i][1], 1));
            list[roads[i][1]].add(new Node(roads[i][0], 1));
        }
        
        int[] dist = dijkstra(destination, n);
        
        for (int i = 0; i < sources.length; i++) {
            if (dist[sources[i]] == INF) {
                answer[i] = -1;
            } else {
                answer[i] = dist[sources[i]];
            }
        }
        
        return answer;
    }
    
    private int[] dijkstra(int destination, int n) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[destination] = 0;
        q.add(new Node(destination, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int cur = curr.end;
            
            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        
        return dist;
    }
}
