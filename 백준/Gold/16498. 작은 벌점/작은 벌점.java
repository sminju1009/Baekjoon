import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int a = 0, b = 0, c = 0;
    static int[] arrA, arrB, arrC;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arrA = new int[a];
        arrB = new int[b];
        arrC = new int[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arrC[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrC);

        for (int i = 0; i < a; i++) {
            check(arrA[i], arrB, arrC);
        }
        for (int i = 0; i < b; i++) {
            check(arrB[i], arrA, arrC);
        }
        for (int i = 0; i < c; i++) {
            check(arrC[i], arrA, arrB);
        }

        System.out.println(answer);
    }

    public static void check(int base, int[] arr1, int[] arr2) {
        int val1 = lowerBoundClosest(base, arr1);
        int val2 = lowerBoundClosest(base, arr2);

        int max = Math.max(base, Math.max(val1, val2));
        int min = Math.min(base, Math.min(val1, val2));
        answer = Math.min(answer, max - min);
    }

    public static int lowerBoundClosest(int value, int[] arr) {
        int left = 0, right = arr.length - 1;
        int result = arr[0];
        int minDiff = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int diff = Math.abs(arr[mid] - value);

            if (diff < minDiff || (diff == minDiff && arr[mid] < result)) {
                minDiff = diff;
                result = arr[mid];
            }

            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < arr.length) {
            int diff = Math.abs(arr[left] - value);
            if (diff < minDiff || (diff == minDiff && arr[left] < result)) {
                result = arr[left];
            }
        }

        return result;
    }
}