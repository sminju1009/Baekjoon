import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h, cnt;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<Pair> list;
    static Pair home;

    static class Pair {
        int y;
        int x;
        public Pair(int y, int x)  {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==1) {
                    home = new Pair(i, j);
                }
                if (arr[i][j]==2) {
                    list.add(new Pair(i, j));
                }
            }
        }
        visited = new boolean[list.size()];
        for (int i = 0; i<list.size(); i++) {
            Pair cur = list.get(i);
            int dist = Math.abs(home.y - cur.y) + Math.abs(home.x - cur.x);
            if (dist<=m) {
                func(cur, i, m-dist+h, 1);
            }
        }
        System.out.println(cnt);
    }

    public static void func(Pair cur, int idx, int hp, int count) {
        visited[idx] = true;
        for (int i = 0; i<list.size(); i++) {
            if (!visited[i]) {
                Pair next = list.get(i);
                int dist = Math.abs(cur.y - next.y) + Math.abs(cur.x - next.x);
                if (dist<=hp) {
                    func(next, i, hp-dist+h, count+1);
                }
            }
        }

        int d = Math.abs(cur.y - home.y) + Math.abs(cur.x - home.x);
        if (d<=hp) {
            cnt = Math.max(cnt, count);
        }
        visited[idx] = false;
    }
}