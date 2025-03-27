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

        System.out.println(func(arr, n));
    }

    public static int func(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                int temp = arr[i] + arr[j];
                int start = 0;
                int end = n-1;
                while (start<end) {
                    if (start==i || start==j) {
                        start++;
                        continue;
                    }
                    if (end==i || end==j) {
                        end--;
                        continue;
                    }
                    int sum = arr[start] + arr[end];
                    min = Math.min(min, Math.abs(temp-sum));
                    if (temp>sum) {
                        start++;
                    } else if (temp<sum) {
                        end--;
                    } else {
                        return 0;
                    }
                }
            }
        }
        return min;
    }
}