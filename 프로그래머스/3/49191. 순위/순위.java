import java.util.*;

public class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        Map<Integer, Set<Integer>> win = new HashMap<>();
        Map<Integer, Set<Integer>> lose = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            win.put(i, new HashSet<>());
            lose.put(i, new HashSet<>());
        }
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            win.get(winner).add(loser);
            lose.get(loser).add(winner);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int winner : win.get(i)) {
                lose.get(winner).addAll(lose.get(i));
            }
            for (int loser : lose.get(i)) {
                win.get(loser).addAll(win.get(i));
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int total = win.get(i).size() + lose.get(i).size();
            if (total == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
