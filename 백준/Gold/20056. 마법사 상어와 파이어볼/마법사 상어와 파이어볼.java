import java.util.*;
import java.io.*;

public class Main {

    static int n, M, k;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static class Fireball {
        int r, c, m, s, d;
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static ArrayList<Fireball>[][] arr;
    static ArrayList<Fireball> fireballs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n][n];
        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        while (k-->0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = new ArrayList<>();
                }
            }

            for (Fireball f : fireballs) {
                move(f);
            }

            fireballs.clear();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j].size() == 0) continue;
                    if (arr[i][j].size() == 1) {
                        fireballs.add(arr[i][j].get(0));
                    } else {
                        divide(i, j);
                    }
                }
            }

        }
        int answer = 0;
        for (Fireball f : fireballs) {
            answer += f.m;
        }
        System.out.println(answer);
    }

    public static void move(Fireball fire) {
        int newR = (fire.r + (dy[fire.d]*fire.s)) % n;
        int newC = (fire.c + (dx[fire.d]*fire.s)) % n;
        if (newR < 0) newR += n;
        if (newC < 0) newC += n;

        arr[newR][newC].add(new Fireball(newR, newC, fire.m, fire.s, fire.d));
    }

    public static void divide(int y, int x) {
        int size = arr[y][x].size();
        int weight = 0;
        int speed = 0;
        int odd = 0, even = 0;

        for (Fireball f: arr[y][x]) {
            weight += f.m;
            speed += f.s;
            if (f.d%2==0) even++;
            else odd++;
        }

        if (weight<5) {
            arr[y][x].clear();
            return;
        } else { // 파이어볼은 4개로 나누어짐!
            if (odd==0 || even==0) {
                for (int i = 0; i<8; i+=2) {
                    fireballs.add(new Fireball(y, x, weight/5, speed/size, i));
                }
            } else {
                for (int i = 1; i<8; i+=2) {
                    fireballs.add(new Fireball(y, x, weight/5, speed/size, i));
                }
            }
        }
        arr[y][x].clear();
    }
}