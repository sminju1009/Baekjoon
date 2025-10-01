import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Stack<Long> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            long now = arr[i];

            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            result += stack.size();

            stack.push(now);
        }

        System.out.println(result);
    }
}