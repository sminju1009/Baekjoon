import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int y, level;

        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 수
        int m = Integer.parseInt(st.nextToken()); // 뱀 수

        int[] board = new int[101]; // 각 위치에서 이동할 위치를 저장
        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 초기화: 이동 없음
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v; // 사다리나 뱀에 의한 이동 저장
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[101]; // 방문 여부 확인
        q.add(new Pair(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int level = curr.level;
            
            if (y == 100) {
                System.out.println(level);
                break;
            }
            
            for (int i = 1; i <= 6; i++) {
                int ny = y + i;
                if (ny > 100) continue;
                ny = board[ny]; // 사다리나 뱀이 있으면 이동
                if (!visited[ny]) {
                    visited[ny] = true;
                    q.add(new Pair(ny, level + 1));
                }
            }
        }
    }
}