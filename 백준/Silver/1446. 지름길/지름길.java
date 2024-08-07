import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int destination;
    int cost;

    public Node(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        for (int i = 0; i <= d; i++) {
            arr.add(new ArrayList<>());
        }

        // 거리를 1로 초기화
        for (int i = 0; i < d; i++) {
            arr.get(i).add(new Node(i + 1, 1));
        }

        // 지름길이 있는 경우에 업데이트
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (b > d) {
                continue;
            }
            arr.get(a).add(new Node(b, c));
        }

        int inf = Integer.MAX_VALUE;
        int[] result = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            result[i] = inf;
        }

        dijkstra(0, arr, result);

        System.out.println(result[d]);
        scanner.close();
    }

    public static void dijkstra(int start, ArrayList<ArrayList<Node>> arr, int[] result) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(start, 0));
        result[start] = 0;

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            int sk = current.cost;
            int k = current.destination;

            if (sk > result[k]) {
                continue;
            }

            for (Node node : arr.get(k)) {
                int cost = sk + node.cost;
                if (cost < result[node.destination]) {
                    result[node.destination] = cost;
                    heap.add(new Node(node.destination, cost));
                }
            }
        }
    }
}
