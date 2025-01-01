import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int y;
        int level;

        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
    }

    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int result = bfs(s, g);
        if (result==-1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int start, int goal) {
        boolean[] visited = new boolean[f+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.y == goal) {
                return curr.level;
            }

            int up = curr.y + u;
            if (up>=1 && up<=f && !visited[up]) {
                visited[up] = true;
                q.add(new Pair(up, curr.level+1));
            }

            int down = curr.y - d;
            if (down>=1 && down<=f && !visited[down]) {
                visited[down] = true;
                q.add(new Pair(down, curr.level+1));
            }
        }
        return -1;
    }
}