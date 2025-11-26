import java.util.*;
import java.io.*;

public class Main {

    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        if (max < 2) {
            StringBuilder sb0 = new StringBuilder();
            for (int v : arr) {
                if (v == 1) sb0.append("1\n"); 
                else sb0.append(v).append("\n");
            }
            System.out.print(sb0.toString());
            return;
        }

        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; (long)i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primes.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int value : arr) {
            if (value == 1) {
                sb.append("1\n");
                continue;
            }

            if (isPrime[value]) {
                sb.append(value).append('\n');
                continue;
            }

            int num = value;
            for (int p : primes) {
                long pp = (long) p * p;
                if (pp > num) break;
                if (num % p == 0) {
                    while (num % p == 0) {
                        sb.append(p).append(' ');
                        num /= p;
                    }
                }
            }
            if (num > 1) { 
                sb.append(num).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}