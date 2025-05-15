import java.util.*;

class Solution {
    
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, new char[numbers.length], 0);
        return count;
    }
    
    public void dfs(int level, int[] numbers, int target, char[] op, int result) {
        if (level==numbers.length) {
            if (result==target) {
                count++;
            }
            return;
        }
        for (int i = 0; i<2; i++) {
            if (i==0) {
                op[level] = '+';
                dfs(level+1, numbers, target, op, result+numbers[level]);
            }
            else if (i==1) {
                op[level] = '-';
                dfs(level+1, numbers, target, op, result-numbers[level]);
            }
        }
    }
}