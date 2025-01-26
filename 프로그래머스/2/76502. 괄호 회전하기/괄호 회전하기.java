import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() == 1) return 0;
        int answer = 0;
        for (int i = 0; i<s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (rotate(s)) answer++;
        }
        return answer;
    }
    
    public boolean rotate(String s) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j<s.length(); j++) {
            char i = s.charAt(j);
            if (i=='(' || i=='[' || i=='{') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.peek()=='(') {
                    if (i==')') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else if (stack.peek() == '[') {
                    if (i==']') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else if (stack.peek() == '{') {
                    if (i=='}') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}