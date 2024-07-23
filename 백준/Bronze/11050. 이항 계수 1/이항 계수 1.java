import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(factorial(n)/factorial(k)/factorial(n-k));
    }

    public static int factorial(int num) {
        int result = 1;
        if (num==0) {
            return 1;
        } else if (num==1) {
            return 1;
        }
        for (int i = 2; i<=num; i++) {
            result *= i;
        }
        return result;
    }
}