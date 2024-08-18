import java.util.*;
import java.io.*;

public class Main {

    public static Queue<Integer> q = new LinkedList<>();
    static int n, k;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        distance = new int[100001];

        bfs(n);
        System.out.println(distance[k]);
    }

    public static void bfs(int num) {
        q.add(num);
        visited[num] = true;

        while (!q.isEmpty()) {
            int newNum = q.poll();

            if (newNum == k) {
                return;
            }

            // 이동 가능한 모든 경우의 수를 탐색
            if (newNum - 1 >= 0 && !visited[newNum - 1]) {
                q.add(newNum - 1);
                visited[newNum - 1] = true;
                distance[newNum - 1] = distance[newNum] + 1;
            }
            if (newNum + 1 <= 100000 && !visited[newNum + 1]) {
                q.add(newNum + 1);
                visited[newNum + 1] = true;
                distance[newNum + 1] = distance[newNum] + 1;
            }
            if (newNum * 2 <= 100000 && !visited[newNum * 2]) {
                q.add(newNum * 2);
                visited[newNum * 2] = true;
                distance[newNum * 2] = distance[newNum] + 1;
            }
        }
    }
}
