import java.util.*;
import java.io.*;

public class Main {

    static class Water {
        int a, b, c;

        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static ArrayList<Integer> answer = new ArrayList<>();
    static int ca, cb, cc;
    static boolean[][][] visited = new boolean[201][201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ca = Integer.parseInt(st.nextToken());
        cb = Integer.parseInt(st.nextToken());
        cc = Integer.parseInt(st.nextToken());

        bfs();
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static void bfs() {
        Queue<Water> q = new LinkedList<>();
        q.add(new Water(0, 0, cc));

        while (!q.isEmpty()) {
            Water water = q.poll();
            int a = water.a;
            int b = water.b;
            int c = water.c;

            if (visited[a][b][c]) continue;

            visited[a][b][c] = true;
            if (a == 0) answer.add(c);

            // A -> B
            if (a + b > cb) {
                q.add(new Water(a - (cb - b), cb, c));
            } else {
                q.add(new Water(0, a + b, c));
            }

            // A -> C
            if (a + c > cc) {
                q.add(new Water(a - (cc - c), b, cc));
            } else {
                q.add(new Water(0, b, a + c));
            }

            // B -> A
            if (b + a > ca) {
                q.add(new Water(ca, b - (ca - a), c));
            } else {
                q.add(new Water(b + a, 0, c));
            }

            // B -> C
            if (b + c > cc) {
                q.add(new Water(a, b - (cc - c), cc));
            } else {
                q.add(new Water(a, 0, b + c));
            }

            // C -> A
            if (c + a > ca) {
                q.add(new Water(ca, b, c - (ca - a)));
            } else {
                q.add(new Water(c + a, b, 0));
            }

            // C -> B
            if (c + b > cb) {
                q.add(new Water(a, cb, c - (cb - b)));
            } else {
                q.add(new Water(a, c + b, 0));
            }
        }
    }
}