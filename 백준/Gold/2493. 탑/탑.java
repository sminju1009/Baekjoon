import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for (int i = n-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                answer[stack.pop()] = i+1;
            }
            stack.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i: answer) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}