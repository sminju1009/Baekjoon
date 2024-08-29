import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int y, x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int n, m;
    static int count = 0;
    static String[][] arr;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visited = new boolean[n][m];
        int sy = 0;
        int sx = 0;
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(a.charAt(j));
                if (arr[i][j].equals("I")) {
                    sy = i;
                    sx = j;
                }
            }
        }
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        q.add(new Pair(sy, sx));
        visited[sy][sx] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x;

            for (int i = 0; i<4; i++) {
                int newY = y+dy[i];
                int newX = x+dx[i];
                if (newY>=0 && newY<n && newX>=0 && newX<m && !arr[newY][newX].equals("X") && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    if (arr[newY][newX].equals("P")) {
                        count++;
                    }
                    q.add(new Pair(newY, newX));
                }
            }
        }
        
        if (count==0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
}