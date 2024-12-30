import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int miss = 0; // hit 횟수
        int hit = 0; // miss 횟수
        Queue<String> q = new LinkedList<>();
        
        for (int i = 0; i<cities.length; i++) {
            String temp = cities[i].toLowerCase();
            if (cacheSize==0) {
                miss++;
            }  else if (q.size() < cacheSize) {
                if (!q.contains(temp)) {
                    miss++;
                    q.add(temp);
                } else {
                    hit++;
                    q.remove(temp);
                    q.add(temp);
                }
            } else if (q.size() >= cacheSize) {
                if (!q.contains(temp)) {
                    miss++;
                    q.poll();
                    q.add(temp);
                } else {
                    hit++;
                    q.remove(temp);
                    q.add(temp);
                }
            }
        }
         
        return hit+miss*5;
    }
}