import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i<progresses.length; i++) {
            days[i] = ((100-progresses[i])%speeds[i] == 0) ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i] + 1;
        }
        
        int prev = days[0];
        int count = 1;
        
        for (int i = 1; i<days.length; i++) {
            if (days[i]<=prev) {
                count++;
            } else {
                result.add(count);
                count = 1;
                prev = days[i];
            }
        }
        
        result.add(count);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}