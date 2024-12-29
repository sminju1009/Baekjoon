import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int now;
        int priority;

        public Pair(int now, int priority) {
            this.now = now;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Pair> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Pair(i, priority));
                pq.add(priority);
            }

            int count = 0;

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                if (curr.priority == pq.peek()) {
                    pq.poll();
                    count++;
                    if (curr.now == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.add(curr);
                }
            }
        }
    }
}