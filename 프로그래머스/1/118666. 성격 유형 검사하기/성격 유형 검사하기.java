import java.util.*;

class Solution {
    
    static int r = 0;
    static int t = 0;
    static int c = 0;
    static int f = 0;
    static int j = 0;
    static int m = 0;
    static int a = 0;
    static int n = 0;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 함수 실행하기
        for (int i = 0; i<survey.length; i++) {
            char temp1 = survey[i].charAt(0);
            char temp2 = survey[i].charAt(1);
            solve(temp1, temp2, choices[i]);
        }
        // 각 항목별 점수 비교하기
        // 1번 지표
        if (r>=t) {
            answer += "R";
        } else {
            answer += "T";
        }
        // 2번 지표
        if (c>=f) {
            answer += "C";
        } else {
            answer += "F";
        }
        // 3번 지표
        if (j>=m) {
            answer += "J";
        } else {
            answer += "M";
        }
        // 4번 지표
        if (a>=n) {
            answer += "A";
        } else {
            answer += "N";
        }
        
        return answer;
    }
    
    public void solve(char char1, char char2, int score) {
        if (score==1) {
            add(char1, 3);
        } else if (score==2) {
            add(char1, 2);
        } else if (score==3) {
            add(char1, 1);
        } else if (score==5) {
            add(char2, 1);
        } else if (score==6) {
            add(char2, 2);
        } else if (score==7) {
            add(char2, 3);
        }
    }
    
    public void add(char now, int score) {
        if (now=='R') {
            r += score;
        } else if (now=='T') {
            t += score;
        } else if (now=='C') {
            c += score;
        } else if (now=='F') {
            f += score;
        } else if (now=='J') {
            j += score;
        } else if (now=='M') {
            m += score;
        } else if (now=='A') {
            a += score;
        } else if (now=='N') {
            n += score;
        }
    }
}