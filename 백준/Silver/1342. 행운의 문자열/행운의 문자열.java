import java.io.*;
import java.util.*;

public class Main {

    static int count;
    static int len;
    static int[] alphabet = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        len = line.length();
        for (int i = 0; i<line.length(); i++) {
            alphabet[line.charAt(i) - 'a']++;
        }

        dfs(0, ' ');
        System.out.println(count);
    }

    public static void dfs(int idx, char pre) {
        if (idx==len) {
            count++;
            return;
        }

        for (int i = 0; i<27; i++) {
            if (alphabet[i]==0) continue;

            if (pre != (char) (i+'a')) {
                alphabet[i]--;
                dfs(idx+1, (char)(i+'a'));
                alphabet[i]++;
            }
        }
    }
}