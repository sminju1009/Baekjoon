import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 1;
        int end = distance;
        
        Arrays.sort(rocks);
        
        int[] newRocks = new int[rocks.length+1];
        for (int i = 0; i<rocks.length; i++) {
            newRocks[i] = rocks[i];
        }
        newRocks[rocks.length] = distance;
        
        while (start<=end) {
            int mid = (start+end) / 2;
            int delete = 0;
            int prevRock = 0;
            
            for (int rock: newRocks) {
                int dist = rock - prevRock;
                if (dist<mid) {
                    delete++;
                    if (delete>n) break;
                } else {
                    prevRock = rock;
                }
            }
            if (delete>n) {
                end = mid-1;
            } else {
                answer = mid;
                start = mid+1;
            }
        }
        
        return answer;
    }
}