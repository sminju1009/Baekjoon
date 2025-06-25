import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int plusCnt = 0;
        int mulCnt = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<n; i++) {
            int now = arr[i];
            int mul = 0;
            while (now>0) {
                if (now%2==1) {
                    now /=2;
                    mul++;
                    plusCnt++;
                } else {
                    now /= 2;
                    mul++;
                    mulCnt = Math.max(mul, mulCnt);
                }
            }
            mulCnt = Math.max(mul-1, mulCnt);
        }
        System.out.println(mulCnt + plusCnt);
    }
}