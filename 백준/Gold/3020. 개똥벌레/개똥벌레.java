import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] up = new int[n/2+n%2];
        int[] down = new int[n/2];
        for (int i = 0; i<n; i++) {
            if (i%2==0) {
                up[i/2] = Integer.parseInt(br.readLine());
            } else {
                down[i/2] = Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(up);
        Arrays.sort(down);
        int min = n, count = 0;

        for (int i = 1; i<h+1; i++) {
            int countWall = lowerBound(0, n/2, i, up) + lowerBound(0, n/2, h-i+1, down);

            if (min==countWall) {
                count++;
            }
            if (min>countWall) {
                min = countWall;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    public static int lowerBound(int left, int right, int target, int[] arr) {
        while (left<right) {
            int mid = (left+right)/2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return arr.length-right;
    }
}