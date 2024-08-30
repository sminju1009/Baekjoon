import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] numX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // X에서 각 숫자가 나오는 횟수
        int[] numY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // Y에서 각 숫자가 나오는 횟수
        int[] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 짝궁 구성
        
        for (int i = 0; i<X.length(); i++) {
            numX[X.charAt(i)-48] += 1;
        }
        
        for (int i = 0; i<Y.length(); i++) {
            numY[Y.charAt(i)-48] += 1;
        }
        
        for (int i = 0; i<10; i++) {
            num[i] = Math.min(numX[i], numY[i]);
        }
        
        for (int i = 9; i>=0; i--) {
            if (num[i]>0) {
                for (int j = 0; j<num[i]; j++) {
                    answer.append(i);
                }
            }
        }
        
        
        if ("".equals(answer.toString())) {
            return "-1";
        } else if (answer.toString().charAt(0)==48) {
            return "0";
        } else {
            return answer.toString();
        }
        
    }
}