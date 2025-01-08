import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String a = br.readLine();
            if (a.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '(' || a.charAt(i) == '[') {
                    stack.add(a.charAt(i));
                } else if (a.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (a.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }


        System.out.println(sb);
    }
}