import java.io.*;
import java.util.*;

public class Main {

    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().trim();

        visited = new boolean[51];

        dfs(new ArrayList<>(), 0);
    }

    public static void dfs(ArrayList<Integer> arr, int level) {
        if (level == str.length()) {
            if (arr.isEmpty()) return;

            int max = 0;
            for (int x : arr) if (x > max) max = x;

            if (max == arr.size()) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.exit(0);
            }
            return;
        }

        // 1자리 수
        int now = str.charAt(level) - '0';
        if (now > 0 && now <= 50 && !visited[now]) {
            visited[now] = true;
            arr.add(now);
            dfs(arr, level + 1);
            arr.remove(arr.size() - 1);
            visited[now] = false;
        }

        // 2자리 수
        if (level + 2 <= str.length() && str.charAt(level) != '0') {
            int longNow = Integer.parseInt(str.substring(level, level + 2));
            if (longNow > 0 && longNow <= 50 && !visited[longNow]) {
                visited[longNow] = true;
                arr.add(longNow);
                dfs(arr, level + 2);
                arr.remove(arr.size() - 1);
                visited[longNow] = false;
            }
        }
    }
}