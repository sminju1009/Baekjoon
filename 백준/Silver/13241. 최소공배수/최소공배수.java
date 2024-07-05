import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long result = 0;
        result = a * b / gcd(a, b);
        System.out.println(result);
    }

    public static long gcd(long num1, long num2) {
        while (num2>0) {
            long temp = 0;
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }
}