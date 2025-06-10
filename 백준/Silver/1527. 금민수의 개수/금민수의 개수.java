import java.util.*;
import java.io.*;

public class Main {
    static long a, b;
    static int alen, blen;
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        alen = String.valueOf(a).length();
        blen = String.valueOf(b).length();
        dfs(0, "");
        System.out.println(arr.size());
    }

    public static void dfs(int level, String result) {
        if (level > blen) return;

        if (!result.isEmpty()) {
            long num = Long.parseLong(result);
            if (result.length() >= alen && result.length() <= blen && num >= a && num <= b) {
                arr.add(num);
            }
            if (num > b) return;
        }

        dfs(level + 1, result + "4");
        dfs(level + 1, result + "7");
    }
}