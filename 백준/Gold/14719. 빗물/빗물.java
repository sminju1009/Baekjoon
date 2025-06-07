import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int answer = 0;
        for (int i = 0; i<w; i++) {
            int count = 0;
            int a = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() < a) {
                if (a > max) {
                    answer += max - stack.pop();
                } else {
                    answer += a - stack.pop();
                    count++;
                }
            }
            for (int j = 0; j<count; j++) {
                stack.push(a);
            }

            max = Math.max(max, a);
            stack.push(a);
        }
        System.out.println(answer);

    }
}