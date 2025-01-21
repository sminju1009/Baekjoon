import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;
        int jobIdx = 0;
        int count = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while (count < jobs.length) {
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                q.add(jobs[jobIdx++]);
            }
            
            if (q.isEmpty()) {
                end = jobs[jobIdx][0];
            } else {
                int[] temp = q.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}