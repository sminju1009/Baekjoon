import java.util.*;

class Solution {
    
    static class Pair{
        int y, x, level;
        
        public Pair(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }
    static int n, m;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        int answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps) {
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int x = curr.x;
            int level = curr.level;
            
            if (y==n-1 && x==m-1) {
                return level;
            }
            
            for (int i = 0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny>=0 && ny<n && nx>=0 && nx<m && !visited[ny][nx] && maps[ny][nx]==1) {
                    visited[ny][nx] = true;
                    q.add(new Pair(ny, nx, level+1));
                }
            }
        }
        return -1;
    }
}