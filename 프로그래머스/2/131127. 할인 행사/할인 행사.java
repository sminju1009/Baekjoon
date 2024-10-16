import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        HashMap<String, Integer> goods = new HashMap<>();
        
        // 1. hashmap에 (원하는 상품의 종류, 상품의 갯수) 쌍 집어넣기
        for (int i = 0; i<want.length; i++) {
            goods.put(want[i], number[i]);
        }
        
        // 2. 비교하기
        for (int i = 0; i<discount.length-days+1; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            for (int j = 0; j<days; j++) {
                temp.put(discount[i+j], temp.getOrDefault(discount[i+j], 0) + 1);
            }
            Boolean isValid = true;
            for (String key:goods.keySet()) {
                if (goods.get(key) != temp.get(key)) {
                    isValid = false;
                    break;
                }
            }
            answer += isValid ? 1 : 0;
            
        }
        return answer;
    }
}