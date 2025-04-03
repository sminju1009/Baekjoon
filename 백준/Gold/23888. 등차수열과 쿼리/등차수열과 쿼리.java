import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            st = new StringTokenizer(br.readLine());
            long now = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            if (now==1) {
                long answer = r * (2*a + (r-1)*d)/2 - (l-1) * (2*a + (l-2)*d) / 2;
                sb.append(answer + "\n");
            } else {
                if (l==r) {
                    sb.append((a + (l-1)*d)+"\n");
                } else {
                    sb.append(gcd(a, d) + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
}