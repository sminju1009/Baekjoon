import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long count = 0;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int target = -(arr[i] + arr[j]);
                
                int left = j + 1;
                int right = n;
                int lowerBound = n;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] >= target) {
                        right = mid;
                        lowerBound = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                
                left = j + 1;
                right = n;
                int upperBound = n;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] > target) {
                        right = mid;
                        upperBound = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                
                if (lowerBound < n) {
                    count += upperBound - lowerBound;
                }
            }
        }

        System.out.println(count);
    }
}