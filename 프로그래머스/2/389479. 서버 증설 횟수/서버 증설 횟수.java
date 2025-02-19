import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int needed = players[i] / m; 

            if (servers[i] < needed) {
                int diff = needed - servers[i];
                answer += diff;
                for (int j = i; j < i + k && j < 24; j++) {
                    servers[j] += diff;
                }
            }
        }
        
        return answer;
    }
}