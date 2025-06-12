import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ioioi = "I";
        for (int i = 0; i<n; i++) {
            ioioi += "OI";
        }
        int strlen = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ilen = 2*n+1;
        int count = 0;
        for (int i = 0; i<strlen-ilen+1; i++) {
            if (str.substring(i, i+ilen).equals(ioioi)) {
                count++;
            }
        }
        System.out.println(count);
    }
}