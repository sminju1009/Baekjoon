import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[100001];
        int answer = 0;
        int start = 0;
        int end = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (end<arr.length) {
            while (end<arr.length && numbers[arr[end]]+1<=k) {
                numbers[arr[end]]++;
                end++;
            }
            int len = end-start;
            answer = Math.max(len, answer);

            numbers[arr[start]]--;
            start++;
        }

        System.out.println(answer);
    }
}