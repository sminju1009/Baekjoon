import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        while (k-->0) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for (int i = sy; i<ey; i++) {
                for (int j = sx; j<ex; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]==0 && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static int bfs(int y, int x) {
        int count = 1;
        visited[y][x] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int d = 0; d<4; d++) {
                int ny = curr.y+dy[d];
                int nx = curr.x+dx[d];
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (!visited[ny][nx] && arr[ny][nx]==0) {
                    q.add(new Pair(ny, nx));
                    count++;
                    visited[ny][nx] = true;
                }
            }
        }

        return count;
    }
}