import java.util.*;

class Solution {
    static boolean[][] visited;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        visited = new boolean[n][n];
        for (int i = 0; i<n; i++) {
            find(arr1[i], n, i);
            find(arr2[i], n, i);
        }
        
        for (int i = 0; i<n; i++) {
            String temp = "";
            for (int j = 0; j<n; j++) {
                if (visited[i][j]) {
                    temp += "#";
                } else {
                    temp += " ";
                }
            }
            answer[i] = temp;
        }
        
        return answer;
    }
    
    public void find(int num, int n, int i) {
        int now = num;
        int index = n-1;
        while (now>0) {
            if (now%2==1) {
                visited[i][index] = true;
            }
            now /= 2;
            index--;
        }
    }
}