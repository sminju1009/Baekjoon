import java.util.*;
import java.io.*;

public class Main {

    static int n, q;
    static int SIZE;
    static int[][] arr;
    static int[] firestorm;
    static boolean[][] isMelt;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int max = 0;
    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        SIZE = (int) Math.pow(2, n);
        arr = new int[SIZE][SIZE];
        firestorm = new int[q];
        for (int i = 0; i<SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<SIZE; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<q; i++) {
            firestorm[i] = Integer.parseInt(st.nextToken());
        }

        for (int f = 0; f<q; f++) {
            int L = firestorm[f];
            if (L > 0) {
                int size = (int) Math.pow(2, L);
                for (int i = 0; i < SIZE; i += size) {
                    for (int j = 0; j < SIZE; j += size) {
                        rotate(i, j, size);
                    }
                }
            }


            isMelt = new boolean[SIZE][SIZE];

            for (int i = 0; i<SIZE; i++) {
                for (int j = 0; j<SIZE; j++) {
                    if (arr[i][j] > 0) {
                        int adjCount = melting(i, j);
                        if (adjCount < 3) isMelt[i][j] = true;
                    }
                }
            }

            for (int i = 0; i<SIZE; i++) {
                for (int j = 0; j<SIZE; j++) {
                    if (isMelt[i][j]) arr[i][j]--;
                }
            }
        }

        visited = new boolean[SIZE][SIZE];

        int answer = 0;
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j<SIZE; j++) {
                answer += arr[i][j];
                if (!visited[i][j] && arr[i][j]>0) bfs(i, j);
            }
        }
        System.out.println(answer);
        System.out.println(max);


    }

    public static void rotate(int y, int x, int size) {
        int[][] temp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = arr[y + i][x + j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[y + i][x + j] = temp[size - 1 - j][i];
            }
        }
    }

    public static int melting(int y, int x) {
        int count = 0;

        for (int d = 0; d<4; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if (ny<0 || ny>=SIZE || nx<0 || nx>=SIZE) continue;
            if (arr[ny][nx]>=1) count++;
        }

        return count;
    }

    public static void bfs(int y, int x) {
        visited[y][x] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        int count = 1;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int d = 0; d<4; d++) {
                int ny = curr.y+dy[d];
                int nx = curr.x+dx[d];
                if (ny<0 || ny>=SIZE || nx<0 || nx>=SIZE) continue;
                if (arr[ny][nx]>0 && !visited[ny][nx]) {
                    count++;
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        max = Math.max(count, max);
    }
}