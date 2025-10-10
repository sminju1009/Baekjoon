import java.util.*;
import java.io.*;

public class Main {

    static int t, g;
    static boolean[] visited = new boolean[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        int answer = bfs(n);

        System.out.println((answer!=-1) ? answer : "ANG");
    }

    public static int bfs(int num) {
        Queue<int[]> q = new LinkedList<>();
        visited[num] = true;
        q.add(new int[]{num, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], level = curr[1];
            if (level>t) return -1;
            if (x==g) return level;

            // 버튼 A
            if (x+1<=99999 && !visited[x+1]) {
                visited[x+1] = true;
                q.add(new int[]{x+1, level+1});
            }

            // 버튼 B
            int b = 2 * x;
            if (b>99999) continue;
            if (b != 0) {
                int minus = 1;
                while (b / minus != 0) minus *= 10;
                b -= minus / 10;
            }

            if (!visited[b]) {
                visited[b] = true;
                q.add(new int[]{b, level + 1});
            }
        }

        return -1;
    }
}