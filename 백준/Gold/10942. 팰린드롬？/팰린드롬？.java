// 이분탐색 활용
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean now = binarySearch(s, e);
            if (now) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }


        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int start, int end) {
        if (start==end) return true;
        while (start<=end) {
            if (arr[start-1] != arr[end-1]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}