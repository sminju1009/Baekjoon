import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x;
        int y;
        int level;

        public Pair(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    static class Points {
        int x;
        int y;

        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Points points = (Points) obj;
            return x == points.x && y == points.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int t;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new ArrayList[t + 1];

        for (int i = 0; i <= t; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y].add(x);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        HashSet<Points> visited = new HashSet<>();

        q.add(new Pair(0, 0, 0));
        visited.add(new Points(0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.y == t) {
                return curr.level;
            }

            for (int i = Math.max(0, curr.y - 2); i <= Math.min(t, curr.y + 2); i++) {
                for (int x : arr[i]) {
                    if (Math.abs(x - curr.x) <= 2 && !visited.contains(new Points(x, i))) {
                        visited.add(new Points(x, i));
                        q.add(new Pair(x, i, curr.level + 1));
                    }
                }
            }
        }

        return -1;
    }
}