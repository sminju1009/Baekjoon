import java.util.*;
import java.io.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        if (str.length() % 2 == 1) {
            System.out.println(0);
        } else {
            if (!isValid()) {
                System.out.println(0);
            } else {
                System.out.println(value());
            }
        }
    }

    public static boolean isValid() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static int value() {
        Stack<Integer> stack = new Stack<>();
        int temp = 1;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                temp *= 2;
                stack.push(-1);
            } else if (ch == '[') {
                temp *= 3;
                stack.push(-2);
            } else if (ch == ')') {
                if (str.charAt(i-1) == '(') {
                    result += temp;
                }
                temp /= 2;
                stack.pop();
            } else if (ch == ']') {
                if (str.charAt(i-1) == '[') {
                    result += temp;
                }
                temp /= 3;
                stack.pop();
            }
        }

        return result;
    }
}