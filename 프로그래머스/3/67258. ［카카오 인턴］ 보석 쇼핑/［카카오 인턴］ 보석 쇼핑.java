import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        HashSet<String> jewerly = new HashSet<>(); // 전체 주얼리 가짓수를 세기 위한 hashset
        HashMap<String, Integer> temp = new HashMap<>(); // 보석의 개수를 세기 위한 HashMap
        
        // 주얼리 가짓수 세기 위한 set
        for (String i: gems) {
            jewerly.add(i);
        }
        
        int start = 0;
        int end = 0;
        temp.put(gems[0], 1); // 첫 번째 보석 추가

        while (end < gems.length) {
            if (temp.size() < jewerly.size()) { // 현재 보석 가짓수가 전체 가짓수보다 작음
                end++;
                if (end < gems.length) {
                    temp.put(gems[end], temp.getOrDefault(gems[end], 0) + 1);
                }
            } else { // 현재 보석 가짓수가 전체 가짓수와 같음
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                temp.put(gems[start], temp.get(gems[start]) - 1);
                if (temp.get(gems[start]) == 0) {
                    temp.remove(gems[start]);
                }
                start++;
            }
        }
        
        return answer;
    }
}
