import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (String i: operations) {
            if (i.charAt(0) == 'I') {
                String[] now = i.split(" ");
                int num = Integer.parseInt(now[1]);
                min.add(num);
                max.add(num);
            } else {
                if (!max.isEmpty()) {
                    if (i.equals("D 1")) {
                        int del = max.poll();
                        min.remove(del);
                    } else {
                        int del = min.poll();
                        max.remove(del);
                    }
                }
            }
        }
        if(max.isEmpty())
            return new int[] {0, 0};
        
        return new int[] {max.peek(), min.peek()};
    }
}