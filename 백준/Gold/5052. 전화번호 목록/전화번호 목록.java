import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[n];
            for (int i = 0 ;i<n; i++) {
                phoneNumber[i] = br.readLine();
            }
            Arrays.sort(phoneNumber);
    
            if (isPossible(n, phoneNumber)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isPossible(int n, String[] arr) {
        for (int i = 0; i<n-1; i++) {
            if (arr[i+1].startsWith(arr[i])) return false;
        }
        return true;
    }
}