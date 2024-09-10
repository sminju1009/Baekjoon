import java.util.*;

class Solution {
    static class Pair {
        int y;
        int x;
        
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[] cnt = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land, visited, cnt);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, cnt[i]);
        }
        return answer;
    }
    
    private void bfs(int startY, int startX, int[][] land, boolean[][] visited, int[] cnt) {
        int n = land.length;
        int m = land[0].length;
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> columns = new HashSet<>();
        int size = 0;
        
        q.offer(new Pair(startY, startX));
        visited[startY][startX] = true;
        columns.add(startX);
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            size++;
            
            for (int k = 0; k < 4; k++) {
                int ny = curr.y + dy[k];
                int nx = curr.x + dx[k];
                
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && land[ny][nx] == 1 && !visited[ny][nx]) {
                    q.offer(new Pair(ny, nx));
                    visited[ny][nx] = true;
                    columns.add(nx);
                }
            }
        }
        
        for (int col : columns) {
            cnt[col] += size;
        }
    }
}