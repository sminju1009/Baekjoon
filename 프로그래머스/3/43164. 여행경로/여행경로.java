import java.util.*;
class Solution {
    
    static String[] answer;
    static boolean[] visited;
    static boolean finished;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new String[tickets.length+1];
        finished = false;
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs(0, "ICN", tickets);
        return answer;
    }
    
    public boolean dfs(int level, String current, String[][] tickets) {
        answer[level] = current;
        
        if (level == tickets.length) {
            finished = true;
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                
                if (dfs(level + 1, tickets[i][1], tickets)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        if (!finished) {
            answer[level] = null;
        }
        
        return false;
    }
}