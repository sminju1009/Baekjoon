import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int time;
        boolean isStart;

        public Pair(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Pair o) {
            return this.time - o.time;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.add(new Pair(Integer.parseInt(st.nextToken()), true));
            q.add(new Pair(Integer.parseInt(st.nextToken()), false));
        }

        int count = 0;
        int answer = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.isStart) {
                count++;
                answer = Math.max(count, answer);
            } else {
                count--;
            }
        }
        System.out.println(answer);
    }
}