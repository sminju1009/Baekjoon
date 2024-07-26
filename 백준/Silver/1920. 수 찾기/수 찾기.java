import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (set.contains(a)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}