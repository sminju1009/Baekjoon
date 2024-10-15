import java.util.*;

class Solution {
    
    static class Pair{
        int y, x;
        
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int maxArea = 0;
    static int count = 0;
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {

        // 초기화
        count = 0;
        maxArea = 0;
        visited = new boolean[m][n];
        
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    
                    maxArea = Math.max(maxArea, bfs(i, j, picture, m, n, picture[i][j]));
                    count++;
                }
            }
        }
        
        
        return new int[]{count, maxArea};
    }
    
    public int bfs(int y, int x, int[][] picture, int m, int n, int color) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visited[y][x] = true;
        
        int areaSize = 1;
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currY = curr.y;
            int currX = curr.x;
            
            for (int i = 0; i < 4; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];
                
                
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && !visited[ny][nx] && picture[ny][nx] == color) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx));
                    areaSize++;
                }
            }
        }
        
        return areaSize;
    }
}