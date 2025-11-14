import java.util.*;
import java.io.*;

public class Main {

    static HashSet<Long> visited = new HashSet<>();
    static long start, end;
    static class Pair {
        long y;
        String result;

        public Pair(long y, String result) {
            this.y = y;
            this.result = result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    public static String bfs() {
        if (start==end) return "0";

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, ""));
        visited.add(start);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.y==end) {
                return curr.result;
            }

            long y = curr.y*curr.y;
            if (!visited.contains(y)) {
                visited.add(y);
                q.add(new Pair(y, curr.result+"*"));
            }

            y = curr.y+curr.y;
            if (!visited.contains(y)) {
                visited.add(y);
                q.add(new Pair(y, curr.result+"+"));
            }

            y = curr.y - curr.y;
            if (!visited.contains(y)) {
                visited.add(y);
                q.add(new Pair(y, curr.result+"-"));
            }

            if (curr.y>0) {
                y = curr.y/curr.y;
                if (!visited.contains(y)) {
                    visited.add(y);
                    q.add(new Pair(y, curr.result+"/"));
                }
            }


        }
        return "-1";
    }
}