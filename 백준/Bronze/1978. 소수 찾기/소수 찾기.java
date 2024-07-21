import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0; // 소수 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
    public static boolean isPrime(int num) {
        if (num==1) {
            return false;
        }
        if (num==2) {
            return true;
        }
        if (num%2==0) {
            return false;
        }
        for (int i = 3; i<=Math.sqrt(num); i+=2) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}