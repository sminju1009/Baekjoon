import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] selected;
    static int answer = Integer.MAX_VALUE;
    static int totalSpaces = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    totalSpaces++;
                } else if (arr[i][j] == 0) {
                    totalSpaces++;
                }
            }
        }
        
        if (virus.size() < m) {
            System.out.println(-1);
            return;
        }
        
        selected = new int[m];
        combination(0, 0);
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void combination(int start, int depth) {
        if (depth == m) {
            int result = bfs();
            if (result != -1) {
                answer = Math.min(answer, result);
            }
            return;
        }
        
        if (virus.size() - start < m - depth) {
            return;
        }
        
        for (int i = start; i < virus.size(); i++) {
            selected[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

    public static int bfs() {
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        Queue<int[]> q = new LinkedList<>();
        int infectedCount = 0;
        
        for (int i = 0; i < m; i++) {
            int[] pos = virus.get(selected[i]);
            int y = pos[0], x = pos[1];
            q.offer(new int[]{y, x, 0});
            visited[y][x] = 0;
            infectedCount++;
        }

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int maxTime = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1], time = curr[2];
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && 
                    visited[ny][nx] == -1 && arr[ny][nx] != 1) {
                    
                    visited[ny][nx] = time + 1;
                    q.offer(new int[]{ny, nx, time + 1});
                    infectedCount++;
                    
                    maxTime = Math.max(maxTime, time + 1);
                    
                    if (infectedCount == totalSpaces) {
                        return maxTime;
                    }
                }
            }
        }
        
        return (infectedCount == totalSpaces) ? maxTime : -1;
    }
}