import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        HashSet<String> voca = new HashSet<>();
        // 비교할 맨 뒤의 글자 기준으로 비교해야 함
        char temp = words[0].charAt(words[0].length()-1);
        voca.add(words[0]);

        for (int i = 1; i<words.length; i++) {
            // 1. temp와 다른 경우 / 2. 이미 해당 단어가 hash
            if (words[i].charAt(0)!=temp || voca.contains(words[i])) {
                if (answer[0]==0 && answer[1]==0) {
                    answer[0] = i%n+1; // 나머지
                    answer[1] = i/n+1; // 몫
                }
            }
            voca.add(words[i]);
            temp = words[i].charAt(words[i].length()-1);
        }
        return answer;
    }
}