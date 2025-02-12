import java.util.*;
import java.io.*;

public class Main {

    static boolean isTrue;
    static char s, e;
    static boolean[] visited = new boolean[26];
    static ArrayList<ArrayList<Character>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<26; i++) {
            arr.add(new ArrayList<>());
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            String[] now = str.split(" ");
            char start = now[0].charAt(0);
            char end = now[2].charAt(0);
            arr.get(start - 'a').add(end);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i<m; i++) {
            String str = br.readLine();
            String[] now = str.split(" ");
            s = now[0].charAt(0);
            e = now[2].charAt(0);
            visited = new boolean[26]; // 매번 초기화
            isTrue = false;
            dfs(s);
            System.out.println((isTrue) ? 'T' : 'F');
        }
    }

    public static void dfs(char start) {
        int now = start - 'a';
        int goal = e - 'a';
        for (char i: arr.get(now)) {
            int temp = i - 'a';
            if (!visited[temp]) {
                visited[temp] = true;
                if (temp==goal) {
                    isTrue = true;
                    return;
                }
                dfs(i);
            }
        }
    }
}