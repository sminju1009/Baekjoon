import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            arr[i] = board[m-i-1].toCharArray();
        }
        
        while (true) {
            boolean flag=true;
            boolean[][] visited = new boolean[m][n];
            
            // 1. 4개가 모인 곳 방문처리 진행하기
            for (int i = 0; i<m-1; i++) {
                for (int j = 0; j<n-1; j++) {
                    if (arr[i][j]=='-') continue;
                    if (arr[i][j]==arr[i][j+1] && arr[i][j]==arr[i+1][j] && arr[i][j]==arr[i+1][j+1]) {
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        flag = false;
                    }
                }
            }
            
            if (flag) break;
            
            // 체크된 블록 삭제
            for (int i = 0; i<m; i++) {
                for (int j = 0; j<n; j++) {
                    if (visited[i][j]) {
                        arr[i][j] = '-';
                        answer++;
                    }
                }
            }
            
            // 블록 내리기(윗 블록과 스왑하기)
            for (int i = 0; i<m; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][j] == '-') {
                        for (int k = i; k<m; k++) {
                            if (arr[k][j] == '-') {
                                continue;
                            }
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '-';
                            break;
                        }
                    }
                }
            }
            
        }
        
        return answer;

    }

}