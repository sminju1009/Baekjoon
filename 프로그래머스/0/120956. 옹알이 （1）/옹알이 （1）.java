class Solution {
    
    static String[] base = new String[]{"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i<babbling.length; i++) {
            for (int j = 0; j<base.length; j++) {
                babbling[i] = babbling[i].replace(base[j], " ");
            }
            
            if (babbling[i].trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
        
    }
}