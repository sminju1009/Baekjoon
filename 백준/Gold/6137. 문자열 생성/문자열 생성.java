import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        for (int i = 0; i<n; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = n-1;
        int count = 0;

        while (start<=end) {
            boolean isLeft = false;
            int left = start;
            int right = end;
            while (left<=right) {
                if (arr[left] < arr[right]) {
                    isLeft = true;
                    break;
                } else if (arr[left] > arr[right]) {
                    isLeft = false;
                    break;
                }
                left++;
                right--;
            }

            if (isLeft) {
                sb.append(arr[start++]);
            } else {
                sb.append(arr[end--]);
            }

            count++;
            if (count==80) {
                sb.append("\n");
                count = 0;
            }
        }
        System.out.println(sb);
    }
}