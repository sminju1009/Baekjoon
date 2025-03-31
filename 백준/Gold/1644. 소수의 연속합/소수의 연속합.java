import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 2; i<=n; i++) {
            if (isPrime(i)) prime.add(i);
        }

        if (prime.isEmpty()) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = 0;
        int answer = prime.get(0);

        while (start<=end && end<prime.size()) {
            if (answer<n) {
                end++;
                if (end<prime.size()) answer += prime.get(end);
            } else if (answer>n) {
                answer -= prime.get(start);
                start++;
            } else if (answer==n) {
                count++;
                end++;
                if (end<prime.size()) answer += prime.get(end);
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int n) {
        if (n<2) {
            return false;
        } else {
            for (int i = 2; i*i<=n; i++) {
                if (n%i==0) return false;
            }
            return true;
        }
    }
}