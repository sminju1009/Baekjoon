import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int level) {
        if (level==n) {
            count++;
            return;
        }

        for (int i = 0; i<n; i++) {
            arr[level] = i;
            if (possibility(level)) {
                nQueen(level+1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i<col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            else if (Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}