import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y;
        int level;

        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
    }

    static int a, b, n, m;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, level = curr.level;
            if (y==m) return level;

            if (y+1>=0 && y+1<=100000 && !visited[y+1]) {
                q.add(new Pair(y+1, level+1));
                visited[y+1] = true;
            }

            if (y-1>=0 && y+1<=100000 && !visited[y-1]) {
                q.add(new Pair(y-1, level+1));
                visited[y-1] = true;
            }

            if (y+a>=0 && y+a<=100000 && !visited[y+a]) {
                q.add(new Pair(y+a, level+1));
                visited[y+a] = true;
            }

            if (y+b>=0 && y+b<=100000 && !visited[y+b]) {
                q.add(new Pair(y+b, level+1));
                visited[y+b] = true;
            }

            if (y-a>=0 && y-a<=100000 && !visited[y-a]) {
                q.add(new Pair(y-a, level+1));
                visited[y-a] = true;
            }

            if (y-b>=0 && y-b<=100000 && !visited[y-b]) {
                q.add(new Pair(y-b, level+1));
                visited[y-b] = true;
            }

            if (y*a>=0 && y*a<=100000 && !visited[y*a]) {
                q.add(new Pair(y*a, level+1));
                visited[y*a] = true;
            }

            if (y*b>=0 && y*b<=100000 && !visited[y*b]) {
                q.add(new Pair(y*b, level+1));
                visited[y*b] = true;
            }
        }

        return -1;
    }
}