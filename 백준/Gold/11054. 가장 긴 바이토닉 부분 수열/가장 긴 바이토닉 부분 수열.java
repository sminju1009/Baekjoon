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
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 0; i<n; i++) {
            int a = arr[i];
            for (int j = 0; j<i; j++) {
                int b = arr[j];
                if (a > b) left[i] = Math.max(left[j]+1, left[i]);
            }
        }
        for (int i = n-1; i>=0; i--) {
            int a = arr[i];
            for (int j = n-1; j>i; j--) {
                int b = arr[j];
                if (a > b) right[i] = Math.max(right[j]+1, right[i]);
            }
        }
        int answer = 0;
        for (int i = 0; i<n; i++) {
            answer = Math.max(answer, right[i] + left[i]);
        }
        System.out.println(answer - 1);
    }
}