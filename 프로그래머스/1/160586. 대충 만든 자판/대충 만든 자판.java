import java.util.*;

class Solution {
    
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int[] answer = new int[targets.length];
        for (int i = 0; i<keymap.length; i++) {
            for (int j = 0; j<keymap[i].length(); j++) {
                String key = String.valueOf(keymap[i].charAt(j));
                if (map.containsKey(key)) {
                    int getValue = map.get(key);
                    map.put(key, Math.min(j+1, getValue));
                } else {
                    map.put(key, j+1);
                }
            }
        }
        
        for (int i = 0; i<targets.length; i++) {
            int count = 0;
            for (int j = 0; j<targets[i].length(); j++) {
                String key = String.valueOf(targets[i].charAt(j));
                if (count != -1) {
                    if (map.containsKey(key)) {
                    Integer value = map.get(key);
                    count += value;
                } else {
                    count = -1;
                    break;
                }
            }
                
            }
            if (count == 0) {
                answer[i] = -1;
            } else {
                answer[i] = count;
            }
        }
        
        return answer;
    }
}