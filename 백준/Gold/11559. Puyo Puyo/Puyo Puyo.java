import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static char[][] arr = new char[12][6];
    static int count = 0;
    static boolean[][] visited;
    static LinkedList<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<12; i++) {
            String line = br.readLine();
            for (int j = 0; j<6; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        while (true) {
            boolean isFinished = true;
            for (int i = 0; i<12; i++) {
                for (int j = 0; j<6; j++) {
                    visited = new boolean[12][6];
                    if (arr[i][j]!='.' && !visited[i][j]) {
                        list = new LinkedList<>();
                        bfs(i, j, arr[i][j]);
                        if (list.size()>=4) {
                            isFinished = false;
                            for (int k = 0; k<list.size(); k++) {
                                arr[list.get(k).y][list.get(k).x] = '.';
                            }
                        }
                    }
                }
            }
            if (isFinished) break;
            swap();
            count++;

        }

        System.out.println(count);

    }

    public static void bfs(int y, int x, char now) {
        Queue<Pair> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Pair(y, x));
        list.add(new Pair(y, x));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i<4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if (ny>=0 && ny<12 && nx>=0 && nx<6 && !visited[ny][nx] && arr[ny][nx]==now) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = true;
                    list.add(new Pair(ny, nx));
                }
            }
        }
    }

    public static void swap() {
        for (int i = 0; i<6; i++) {
            for (int j = 11; j>0; j--) {
                if (arr[j][i]=='.') {
                    for (int k = j-1; k>=0; k--) {
                        if (arr[k][i]!='.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}