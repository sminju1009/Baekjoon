import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] visited;
    static int A, B, C;
    static int answer = 0;
    static class Pair {
        int a, b, c;

        public Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if ((A+B+C)%3!=0) {
            System.out.println(answer);
            return;
        }

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(A, B, C));
        visited = new boolean[3001][3001];
        visited[A][B] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int a = curr.a, b = curr.b, c = curr.c;
            if (a==b && b==c) {
                answer = 1;
                return;
            }

            if (a!=b) {
                int na = a>b ? a-b : a+a;
                int nb = a>b ? b+b : b-a;
                if (!visited[na][nb]) {
                    q.add(new Pair(na, nb, c));
                    visited[na][nb] = true;
                }
            }

            if (a!=c) {
                int na = a>c ? a-c : a+a;
                int nc = a>c ? c+c : c-a;
                if (!visited[na][nc]) {
                    q.add(new Pair(na, b, nc));
                    visited[na][nc] = true;
                }
            }

            if (b!=c) {
                int nb = b>c ? b-c : b+b;
                int nc = b>c ? c+c : c-b;
                if (!visited[nb][nc]) {
                    q.add(new Pair(a, nb, nc));
                    visited[nb][nc] = true;
                }
            }
        }
    }
}