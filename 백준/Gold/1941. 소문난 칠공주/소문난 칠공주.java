import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;
    static char[][] arr = new char[5][5];
    static boolean[] visited = new boolean[25];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0, 0, 0);
        System.out.println(count);
    }

    public static void dfs(int level, int idx, int dasom, int doyeon) {
        if (doyeon >= 4) return;
        if (level == 7) {
            if (dasom >= 4 && isConnected()) {
                count++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            int y = i / 5;
            int x = i % 5;

            visited[i] = true;
            if (arr[y][x] == 'S') {
                dfs(level + 1, i + 1, dasom + 1, doyeon);
            } else {
                dfs(level + 1, i + 1, dasom, doyeon + 1);
            }
            visited[i] = false;
        }
    }

    public static boolean isConnected() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] tempVisited = new boolean[25];
        int connectedCount = 0;

        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                q.add(i);
                tempVisited[i] = true;
                break;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int y = cur / 5;
            int x = cur % 5;
            connectedCount++;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int next = ny * 5 + nx;

                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && visited[next] && !tempVisited[next]) {
                    tempVisited[next] = true;
                    q.add(next);
                }
            }
        }

        return connectedCount == 7;
    }
}