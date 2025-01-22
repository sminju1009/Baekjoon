import java.util.*;
import java.io.*;

public class Main {

    final static long mod = 1000000007;
    static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        memo.put(0L, 0L);
        memo.put(1L, 1L);
        memo.put(2L, 1L);
        memo.put(3L, 2L);
        long answer = fibo(n);
        System.out.println(Long.valueOf(answer).intValue());
    }

    public static long fibo(long num) {
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        long a, b, c;
        if (num%2==1) {
            a = fibo(num/2+1);
            b = fibo(num/2);
            memo.put(num, ((a%mod) * (a%mod) % mod + (b%mod) * (b%mod) % mod) % mod);
        } else {
            a = fibo(num/2 + 1);
            b = fibo(num/2);
            c = fibo(num/2 - 1);
            memo.put(num, ((a % mod) * (b % mod) % mod + (b % mod) * (c % mod) % mod) % mod);
        }
        return memo.get(num);
    }
}