import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int y, x;
        boolean isWater;
        
        public Pair(int y, int x, boolean isWater) {
            this.y = y;
            this.x = x;
            this.isWater = isWater;
        }
    }
    
    static Queue<Pair> q = new LinkedList<>();
    static int r, c;
    static char[][] arr;
    static int[][] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        dist = new int[r][c];
        int ey = 0, ex = 0; 
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'D') {
                    ey = i;
                    ex = j;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '*') {
                    q.add(new Pair(i, j, true));
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'S') {
                    q.add(new Pair(i, j, false));
                }
            }
        }
        
        System.out.println(bfs(ey, ex));
    }
    
    public static String bfs(int ey, int ex) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        boolean[][] visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'S') {
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int y = now.y;
            int x = now.x;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                
                if (now.isWater) {
                    if (arr[ny][nx] == '.' || arr[ny][nx] == 'S') {
                        arr[ny][nx] = '*';
                        q.add(new Pair(ny, nx, true));
                    }
                } else {  
                    if (arr[ny][nx] == 'D') {
                        return String.valueOf(dist[y][x] + 1);
                    }

                    if (!visited[ny][nx] && arr[ny][nx] == '.') {
                        visited[ny][nx] = true;
                        dist[ny][nx] = dist[y][x] + 1;
                        q.add(new Pair(ny, nx, false));
                    }
                }
            }
        }
        
        return "KAKTUS";
    }
}