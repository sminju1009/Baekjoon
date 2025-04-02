import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        System.out.println(solve(b) - solve(a - 1));
    }
    
    public static long solve(long n) {
        if (n <= 0) return 0;
        
        long result = 0;
        for (long i = 1; i <= n; i *= 2) {
            result += (n / i + 1) / 2 * i;
        }
        
        return result;
    }
}