import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1] - arr[0] + 1;

        while (left<right) {
            int mid = (left+right) / 2;
            if (canInstall(mid) < c) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }

    public static int canInstall(int dist) {
        int count = 1;
        int highest = arr[0];

        for (int i = 1; i<arr.length; i++) {
            int locate = arr[i];

            if (locate - highest >= dist) {
                count++;
                highest = locate;
            }
        }
        return count;
    }
}