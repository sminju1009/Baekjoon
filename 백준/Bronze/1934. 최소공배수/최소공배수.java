import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 0;
            result = a * b / gcd(a, b);
            System.out.println(result);
        }
    }

    public static int gcd(int num1, int num2) {
        while (num2>0) {
            int temp = 0;
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }
}