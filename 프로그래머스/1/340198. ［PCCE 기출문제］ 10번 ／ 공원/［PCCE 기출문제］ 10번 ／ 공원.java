import java.util.*;

class Solution {
    public static int answer = -1;
    public static int width, height;
    
    public int solution(int[] mat, String[][] park) {
        width = park[0].length;
        height = park.length;
        // 1. 내림차순으로 돗자리 배열
        int[] mats = new int[mat.length];
        Arrays.sort(mat);
        for (int i = 0; i<mat.length; i++) {
            mats[mat.length-1-i] = mat[i];
        }
        
        // 2. 공원에서 가능한지 찾기
        for (int i = 0; i<mats.length; i++) {
            if (findPlace(mats[i], park)) {
                answer = mats[i];
                break;
            }
        }
        return answer;
        
    }
    
    public boolean findPlace(int n, String[][] park) {
        
        for (int i = 0; i<height-n+1; i++) {
            for (int j = 0; j<width-n+1; j++) {
                boolean isTrue = true;
                for (int k = 0; k<n; k++) {
                    for (int l = 0; l<n; l++) {
                        if (!park[i+k][j+l].equals("-1")) {
                            isTrue = false;
                            break;
                        }
                    }
                    if (!isTrue) break;
                }
                if (isTrue) return true;
            }
        }
        return false;
    }
}