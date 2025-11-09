import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count1 = 0;
        int count2 = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            count1 += (a%2);
            count2 += (a/2);
        }
        if ((sum%3==0) && (count1<=count2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}