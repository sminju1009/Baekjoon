import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int s;
        int level;

        public Pair(int s, int level) {
            this.s = s;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start == end) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int count = 0;
        int time = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100001];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int now = curr.s;
            int level = curr.level;
            
            visited[now] = true;

            if (time < level) continue;
            
            int[] nextPositions = {now + 1, now - 1, now * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000) {
                    if (!visited[next]) {
                        if (next == end) {
                            if (time > level + 1) {
                                time = level + 1;
                                count = 1;
                            } else if (time == level + 1) {
                                count++;
                            }
                        }
                        q.add(new Pair(next, level + 1));
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(count);
    }
}