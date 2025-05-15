import java.util.*;

class Solution {
    
    static class Pair {
        int y, level;
        
        public Pair(int y, int level) {
            this.y = y;
            this.level = level;
        }
        
        
    }
    static int[] visited;
    static ArrayList<ArrayList<Integer>> arr;
    static int max = 0;
    
    public int solution(int n, int[][] edge) {
        visited = new int[n+1];
        arr = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] now: edge) {
            int a = now[0];
            int b = now[1];
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        int answer = 0;
        bfs();
        for (int i = 1; i<=n; i++) {
            if (visited[i]==max) {
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            int level = curr.level;
            
            for (int i: arr.get(y)) {
                if (i!=1 && visited[i]==0) {
                    visited[i] = level+1;
                    q.add(new Pair(i, level+1));
                    max = Math.max(max, level+1);
                }
            }
            
        }
        
    }
}