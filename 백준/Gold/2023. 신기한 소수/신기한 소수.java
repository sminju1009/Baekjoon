import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static List<Integer> primes = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        Collections.sort(primes);
        for (int now : primes) {
            sb.append(now).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level == n) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp = temp * 10 + arr[i];
            }
            primes.add(temp);
            return;
        }

        if (level == 0) {
            for (int i : new int[]{2, 3, 5, 7}) {
                arr[level] = i;
                dfs(level + 1);
                arr[level] = 0;
            }
        } else {
            for (int i : new int[]{1, 3, 5, 7, 9}) {
                arr[level] = i;
                // 소수인지 먼저 판별을 하고 소수인 경우에만 dfs 돌려버리기 - 경우의 수를 줄여버려서 시간 초과 방지
                int num = 0;
                for (int j = 0; j<=level; j++) {
                    num += (int) Math.pow(10, level-j) * arr[j];
                }
                if (isPrime(num)) {
                    dfs(level + 1);
                }
                arr[level] = 0;
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}