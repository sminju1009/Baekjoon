import java.util.*;

class Solution {
    
    static char[] arrays = new char[8];  // 프렌즈 배열
    static boolean[] visited = new boolean[8];  // 방문 여부 체크
    static int count = 0;  // 조건을 만족하는 경우의 수
    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};  // 프렌즈 목록
    
    public int solution(int n, String[] data) {
        count = 0; 
        dfs(0, data);
        return count;
    }
    
    // 모든 경우의 수를 체크하기 위한 메서드
    public static void dfs(int level, String[] data) {
        if (level == 8) {  
            if (isOk(arrays, data)) {
                count++; 
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {  
                visited[i] = true;
                arrays[level] = friends[i];
                dfs(level + 1, data);
                visited[i] = false;
            }
        }
    }
    
    // 조건에 맞는지 검사하는 함수
    public static boolean isOk(char[] arrays, String[] data) {
        String orders = new String(arrays);  // 현재 프렌즈 순서를 문자열로 변환
        
        for (String s : data) {
            int first = orders.indexOf(s.charAt(0));  // 첫 번째 프렌즈 위치
            int second = orders.indexOf(s.charAt(2));  // 두 번째 프렌즈 위치
            char op = s.charAt(3);  // 연산자 (>, <, =)
            int length = s.charAt(4) - '0';  // 거리 조건
            
            int dist = Math.abs(first - second) - 1;  // 실제 거리 계산
            
            if (op == '=') {
                if (dist != length) return false;
            } else if (op == '>') {
                if (dist <= length) return false;
            } else if (op == '<') {
                if (dist >= length) return false;
            }
        }
        return true;
    }
}