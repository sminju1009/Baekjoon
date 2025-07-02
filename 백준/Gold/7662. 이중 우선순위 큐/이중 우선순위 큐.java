import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            TreeMap<Integer, Integer> q = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i<n; i++) {
                String str = br.readLine();
                if (str.charAt(0)=='I') {
                    String[] now = str.split(" ");
                    int num = Integer.parseInt(now[1]);
                    q.put(num, q.getOrDefault(num, 0) + 1);
                } else {
                    if (q.size()>0) {
                        int num = (str.equals("D 1") ? q.lastKey() : q.firstKey());
                        if (q.get(num)==1) {
                            q.remove(num);
                        } else {
                            q.put(num, q.get(num) - 1);
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(q.lastKey() + " " + q.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}