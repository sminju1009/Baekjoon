import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        where(r, c, n);
        System.out.println(count);

    }

    // 몇 사분면인지 판단
    public static void where(int a, int b, int size) {
        if (a!=0 || b!=0) {
            int divided = (int) Math.pow(2, size-1);
            int pow = (int) Math.pow(2, 2*(size-1));
            // 1사분면
            if (a>=0 && a<divided && b>=0 && b<divided) {
                where(a, b, size-1);
            } // 2사분면
            else if (a>=0 && a<divided && b>=divided && b<divided*2) {
                count += pow;
                where(a, b-divided, size-1);

            } // 3사분면
            else if (a>=divided && a<divided*2 && b>=0 && b<divided) {
                count += pow*2;
                where(a-divided, b, size-1);
            } // 4사분면
            else if (a>=divided && a<divided*2 && b>=divided && b<divided*2) {
                count += pow*3;
                where(a-divided, b-divided, size-1);
            }
        }
    }
}