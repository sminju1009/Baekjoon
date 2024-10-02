import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(moduler(a, b, c));
    }

    public static long moduler(int n, int m, int k) {
        if (m == 0) {
            return 1;
        }

        long half = moduler(n, m / 2, k);
        half = (half * half) % k;

        if (m % 2 != 0) {
            half = (half * n) % k;
        }
        return half;
    }
}