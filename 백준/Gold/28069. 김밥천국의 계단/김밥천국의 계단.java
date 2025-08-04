import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        int answer = bfs();
        if (answer==-1 || answer>k) {
            System.out.println("water");
        } else {
            System.out.println("minigimbob");
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], level = curr[1];
            if (y==n) {
                if (level>k) {
                    return -1;
                } else {
                    return level;
                }
            }

            if (y+1>=0 && y+1<=n && !visited[y+1]) {
                visited[y+1] = true;
                q.add(new int[]{y+1, level+1});
            }

            if (y+y/2>=0 && y+y/2<=n && !visited[y+y/2]) {
                visited[y+y/2] = true;
                q.add(new int[]{y+y/2, level+1});
            }
        }
        return -1;
    }
}