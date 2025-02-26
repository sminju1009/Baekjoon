import java.util.*;
import java.io.*;

public class Main {
    static Queue<Pair> q = new LinkedList<>();
    static int n, k;
    static int s, y, x;
    static int[][] arr;
    static class Pair {
        int y, x, value, level;

        public Pair(int y, int x, int value, int level) {
            this.y = y;
            this.x = x;
            this.value = value;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        ArrayList<Pair> array = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]!=0) {
                    array.add(new Pair(i, j, arr[i][j], 0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        Collections.sort(array, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });

        for (Pair pair: array) {
            q.add(pair);
        }

        bfs();
        System.out.println(arr[y-1][x-1]);
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.level == s) {
                return;
            }

            int[] dy = {0, 1, 0, -1};
            int[] dx = {1, 0, -1, 0};
            for (int i = 0; i<4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<n && arr[ny][nx]==0) {
                    arr[ny][nx] = curr.value;
                    q.add(new Pair(ny, nx, curr.value, curr.level+1));
                }
            }
        }
    }
}