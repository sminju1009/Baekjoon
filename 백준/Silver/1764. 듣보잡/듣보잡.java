import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i<n; i++) {
            set.add(br.readLine());
        }
        int count = 0;
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i<m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                count++;
                result.add(name);
            }
        }
        System.out.println(count);
        Collections.sort(result);
        for (int i = 0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}