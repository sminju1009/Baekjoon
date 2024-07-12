import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ans1 = gcd(a, b);
        int ans2 = lcm(a, b);

        System.out.println(ans1);
        System.out.println(ans2);

    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x%y);
    }

    public static int lcm(int x, int y) {
        return (x*y)/gcd(x, y);
    }
}
