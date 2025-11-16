import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int count = 0;
        for (int i = 0; i<n; i++) {
            if (str.charAt(i)=='a') count++;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i<n; i++) {
            int temp = 0;
            for (int j = i; j<i+count; j++) {
                int now = j%n;
                if (str.charAt(now)=='b') temp++;
            }
            answer = Math.min(answer, temp);
        }
        System.out.println(answer);
    }
}