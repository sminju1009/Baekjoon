import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited = new boolean[26];
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }

        if (k<5) {
            System.out.println(0);
            return;
        } else if (k==26){
            System.out.println(n);
            return;
        }

        // 각 알파벳을 배웠는지 체크하기
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        
        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int alpha, int len) {
        if (len==k-5) {
            int count = 0;
            for (int i = 0; i<n; i++) {
                boolean read = true;
                for (int j = 0; j<word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) count++;
            }
            max = Math.max(max, count);
            return;
        }
        
        for (int i = alpha; i<26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, len+1);
                visited[i] = false;
            }
        }
    }
}