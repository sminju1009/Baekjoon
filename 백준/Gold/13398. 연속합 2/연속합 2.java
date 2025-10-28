import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp1 = new int[n];
        dp1[0] = arr[0];
        for (int i = 1; i<n; i++) {
            dp1[i] = Math.max(arr[i], dp1[i-1] + arr[i]);
        }

        int[] dp2 = new int[n];
        dp2[n-1] = arr[n-1];
        for (int i = n-2; i>=0; i--) {
            dp2[i] = Math.max(arr[i], dp2[i+1]+arr[i]);
        }

        int answer1 = Integer.MIN_VALUE;
        for (int i = 1; i<n-1; i++) {
            answer1 = Math.max(answer1, dp1[i-1] + dp2[i+1]);
        }

        int answer2 = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            answer2 = Math.max(answer2, dp1[i]);
        }
        System.out.println(Math.max(answer1, answer2));


    }
}
