import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MIN_VALUE;
    static int a, b;
    static int lenA;
    static int[] isA = new int[10];
    static int[] visited = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        String nowA = String.valueOf(a);
        lenA = nowA.length();
        
        if (!isValid()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < nowA.length(); i++) {
                int now = nowA.charAt(i) - '0';
                isA[now]++;
            }
            
            for (int i = 1; i < 10; i++) {
                if (isA[i] > 0) {
                    visited[i]++;
                    dfs(1, String.valueOf(i));
                    visited[i]--;
                }
            }
            
            System.out.println((answer != Integer.MIN_VALUE) ? answer : -1);
        }
    }

    // A가 B보다 작은 경우가 절대 나올 수 없는 경우 => A의 자릿수가 B의 자릿수보다 더 많을 때
    public static boolean isValid() {
        String nowA = String.valueOf(a);
        String nowB = String.valueOf(b);
        if (nowA.length() > nowB.length()) {
            return false;
        }
        return true;
    }

    public static void dfs(int level, String value) {
        if (level == lenA) {
            int result = Integer.parseInt(value);
            if (result < b) {
                answer = Math.max(answer, result);
            }
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (isA[i] > 0 && visited[i] < isA[i]) {
                visited[i]++;
                dfs(level + 1, value + i);
                visited[i]--;
            }
        }
    }
}