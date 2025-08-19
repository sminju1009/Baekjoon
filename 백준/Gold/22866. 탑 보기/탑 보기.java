import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[n+1];       
        int[] nearest = new int[n+1];     
        int[] minDist = new int[n+1];   
        Arrays.fill(minDist, Integer.MAX_VALUE);

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            count[i] += stack.size();

            if (!stack.isEmpty()) {
                int closest = stack.peek();
                int dist = i - closest;
                if (dist < minDist[i]) {
                    minDist[i] = dist;
                    nearest[i] = closest;
                }
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n; i >= 1; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            count[i] += stack.size();

            if (!stack.isEmpty()) {
                int closest = stack.peek();
                int dist = closest - i;
                if (dist < minDist[i]) {
                    minDist[i] = dist;
                    nearest[i] = closest;
                }
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                sb.append("0\n");
            } else {
                sb.append(count[i]).append(" ").append(nearest[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}