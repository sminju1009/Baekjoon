import java.io.*;
import java.util.*;

public class Main {
    static List<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dfs(9, 0);
        Collections.sort(arr);

        if (n > arr.size()) System.out.println(-1);
        else System.out.println(arr.get(n - 1));
    }

    public static void dfs(int num, long now) {
        if (!arr.contains(now)) {
            arr.add(now);
        }
        for (int i = num; i >= 0; i--) {
            dfs(i - 1, now * 10 + i);
        }
    }
}