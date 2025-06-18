import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i)=='(') {
                left++;
                sum++;
            } else {
                right++;
                sum--;
            }
            if (sum<0) {
                System.out.println(right);
                return;
            }
            if (sum==0) {
                left = 0;
            }
        }
        System.out.println(left);
    }
}