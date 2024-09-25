import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            String a = st.nextToken();
            String[] b = a.split("");
            String c = "";
            for (int j = 0; j<b.length; j++) {
                for (int k = 0; k<m; k++) {
                    c += b[j];
                }
            }
            System.out.println(c);
        }
    }
}