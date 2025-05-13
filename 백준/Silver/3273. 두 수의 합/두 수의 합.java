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
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n-1;
        int answer = 0;

        while (start<end) {
            int temp = arr[start] + arr[end];
            if (temp==x) {
                answer++;
                end--;
            } else if (temp>x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer);
    }
}