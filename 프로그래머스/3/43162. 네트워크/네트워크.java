import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arr;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        arr = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (i!=j && computers[i][j]==1) {
                    arr.get(i).add(j);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i: arr.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}