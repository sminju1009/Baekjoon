import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i: scoville) {
            heap.add(i);
        }
        
        while (heap.peek() < K) {
            if (heap.size()<2) return -1;
            int num1 = heap.poll();
            int num2 = heap.poll();
            int temp = num1 + 2 * num2;
            answer++;
            heap.add(temp);
        }
        
        return answer;
    }
}