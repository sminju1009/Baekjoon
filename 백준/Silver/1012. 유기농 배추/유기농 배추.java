import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            int n = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 갯수

            int[][] arr = new int[n][m];
            int answer = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 위치 (가로)
                int y = Integer.parseInt(st.nextToken()); // 배추의 위치 (세로)
                arr[y][x] = 1; // 배추가 있는 곳은 1로 바꿔줌
            }

            for (int j = 0; j < n; j++) {
                for (int p = 0; p < m; p++) {
                    if (arr[j][p] == 1) {  // 아직 방문하지 않은 배추라면
                        bfs(j, p, arr, n, m);
                        answer++;  // 새로운 군집이 발견될 때만 증가
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(int startY, int startX, int[][] arr, int n, int m) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        q = new LinkedList<>();
        q.add(new Pair(startY, startX));
        arr[startY][startX] = 0;  // 시작 지점을 방문 처리

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];

                if (newY >= 0 && newX >= 0 && newY < n && newX < m && arr[newY][newX] == 1) {
                    arr[newY][newX] = 0;  // 방문 처리
                    q.add(new Pair(newY, newX));
                }
            }
        }
    }
}