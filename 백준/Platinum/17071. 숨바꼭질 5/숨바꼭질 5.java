import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, k));
    }
    
    public static int bfs(int n, int k) {
        if (n == k) return 0;
        
        boolean[][] visited = new boolean[500001][2];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(n);
        visited[n][0] = true;
        int level = 0;
        
        while (!q.isEmpty()) {
            level++;
            int end = k + level * (level + 1) / 2;
            
            if (end > 500000) return -1;
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int y = q.poll();
                
                int[] next = {y + 1, y - 1, y * 2};
                
                for (int ny : next) {
                    if (ny < 0 || ny > 500000) continue;
                    if (visited[ny][level % 2]) continue;
                    
                    if (ny == end) return level;
                    
                    visited[ny][level % 2] = true;
                    q.add(ny);
                }
            }
            
            if (visited[end][level % 2]) return level;
        }
        
        return -1;
    }
}