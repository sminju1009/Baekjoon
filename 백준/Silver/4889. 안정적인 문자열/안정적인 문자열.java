import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '-') {
                break;
            }
            tc++;
            isSafe(str);
            sb.append(tc + ". " + count + "\n");
        }
        System.out.println(sb);
    }

    public static boolean isSafe(String str) {
        int cnt = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i)=='{') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    stack.push('{');
                    cnt++;
                } else {
                    stack.pop();
                }
            }
        }

        count = cnt + stack.size()/2;
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}