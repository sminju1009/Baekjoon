import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int now = lcm/gcd;

        long resA = 0; long resB = 0;
        for (int i = 1; i*i<=now; i++) {
            if (now%i==0) {
                int a = i;
                int b = now/i;
                if (gcd(a, b)==1) {
                    resA = a*gcd;
                    resB = b*gcd;
                }
            }
        }

        System.out.println(resA + " " + resB);
    }

    public static long gcd(int a, int b) {
        return a%b==0 ? b:gcd(b, a%b);
    }
}