import java.util.*;

class Pair{
    int y, x, dir, cost;
    
    public Pair(int y, int x, int dir, int cost) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    
    static int result = Integer.MAX_VALUE;
    static int[][] visited;
        
    public int solution(int[][] board) {
        visited = new int[board.length][board.length];
        return bfs(board);
    }
    
    public int bfs(int[][] board) {
        Queue<Pair> q = new LinkedList<>();
        int[] dy = new int[]{0, 0, -1, 1};
        int[] dx = new int[]{-1, 1, 0, 0};
        q.add(new Pair(0, 0, 1, 100));
        q.add(new Pair(0, 0, 3, 100));
        visited[0][0] = 100;
        
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            
            if (cur.x == board.length-1 && cur.y == board.length-1) {
                result = Math.min(result, cur.cost);
                continue;
            }
            
            for (int i = 0; i<4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if (ny>=0 && ny<board.length && nx>=0 && nx<board.length && board[ny][nx]==0) {
                    int weight = cur.dir == i ? 100 : 600;
                    if (visited[ny][nx]==0) {
                        visited[ny][nx] = cur.cost + weight;
                        q.add(new Pair(ny, nx, i, cur.cost+weight));
                    } else if (cur.cost+weight < visited[ny][nx] + 500) {
                        visited[ny][nx] = cur.cost+weight;
                        q.add(new Pair(ny, nx, i, cur.cost+weight));
                    }
                }
            }
        }
        return result - 100;
    }
}