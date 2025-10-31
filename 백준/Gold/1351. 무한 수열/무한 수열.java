import java.util.*;
import java.io.*;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static int p, q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        map.put(0L, 1L);
        System.out.println(solve(n));
    }
    
    static long solve(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        long result = solve(n/p) + solve(n/q);
        map.put(n, result);
        return result;
    }
}