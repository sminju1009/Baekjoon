import java.util.*;

class Solution {
    
    static HashMap<String, String> parent = new HashMap<>();
    static HashMap<String, Integer> money = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i<seller.length; i++) {
            share(seller[i], amount[i]*100);
        }
        
        for (int i = 0; i<enroll.length; i++) {
            answer[i] = money.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    public void share(String seller, int sales) {
        int newSales = sales/10;
        money.put(seller, money.getOrDefault(seller, 0) + sales - newSales);
        
        if (newSales>0 && parent.containsKey(seller)) {
            share(parent.get(seller), newSales);
        }
    }
}