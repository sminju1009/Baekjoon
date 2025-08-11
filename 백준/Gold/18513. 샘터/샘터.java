import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, level;

        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
    }

    static int n, k;
    static Set<Integer> visited = new HashSet<>();
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            visited.add(a);
            q.add(new Pair(a, 0));
        }

        long count = 0;
        long dist = 0;
        
        while (!q.isEmpty() && count < k) {
            Pair curr = q.poll();
            int y = curr.y;
            int level = curr.level;

            int[] dy = {-1, 1};
            for (int d = 0; d < 2; d++) {
                if (count == k) break;

                int ny = y + dy[d];

                if (!visited.contains(ny)) {
                    visited.add(ny);
                    q.add(new Pair(ny, level + 1));
                    
                    count++;
                    dist += level + 1;
                }
            }
        }
        System.out.println(dist);
    }
}