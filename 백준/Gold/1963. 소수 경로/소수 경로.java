import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, level;

        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
    }
    static boolean[] isPrime = new boolean[10001];
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start==end) {
                sb.append("0" + "\n");
            } else {
                if (bfs(start, end)==-1) {
                    sb.append("Impossible\n");
                } else {
                    sb.append(bfs(start, end) + "\n");
                }
            }
        }
        System.out.println(sb);

    }

    public static void isPrime() {
        for (int i = 0; i<=10000; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i<=Math.sqrt(10000); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j<=10000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int bfs(int start, int end) {
        visited = new boolean[10001];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, level = curr.level;

            if (y==end) return level;

            for (int i = -9000; i<=9000; i+=1000) {
                if (i==0) continue;
                if (y+i<1000 || y+i>9999) continue;

                if (isPrime[y+i] && !visited[y+i]) {
                    visited[y+i] = true;
                    q.add(new Pair(y+i, level+1));
                }
            }

            for (int i = -900; i<=900; i+=100) {
                if (i==0) continue;
                if (y+i<1000 || y+i>9999) continue;
                if ((y+i)/1000 != y/1000) continue;

                if (isPrime[y+i] && !visited[y+i]) {
                    visited[y+i] = true;
                    q.add(new Pair(y+i, level+1));
                }
            }

            for (int i = -90; i<=90; i+=10) {
                if (i==0) continue;
                if (y+i<1000 || y+i>9999) continue;
                if ((y+i)/100 != y/100) continue;

                if (isPrime[y+i] && !visited[y+i]) {
                    visited[y+i] = true;
                    q.add(new Pair(y+i, level+1));
                }
            }

            for (int i = -9; i<=9; i++) {
                if (i==0) continue;
                if (y+i<1000 || y+i>9999) continue;
                if ((y+i)/10 != y/10) continue;

                if (isPrime[y+i] && !visited[y+i]) {
                    visited[y+i] = true;
                    q.add(new Pair(y+i, level+1));
                }
            }
        }

        return -1;
    }
}