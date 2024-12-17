import java.util.*;

class Pair {
    int now;
    int level;
    
    public Pair(int now, int level) {
        this.now = now;
        this.level = level;
    }
}

class Solution {
    
    static boolean[] visited = new boolean[3000001];
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs(int start, int end, int v) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start] = true;
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int now = curr.now;
            int level = curr.level;
            
            if (now == end) {
                return level;
            }
            
            if (now*3<=3000000 && !visited[now*3]) {
                visited[now*3] = true;
                q.add(new Pair(now*3, level+1));
            }
            if (now*2<=3000000 && !visited[now*2]) {
                visited[now*2] = true;
                q.add(new Pair(now*2, level+1));
            }
            if (now+v<=3000000 && !visited[now+v]) {
                visited[now+v] = true;
                q.add(new Pair(now+v, level+1));
            }
        } 
        return -1;
    }
}