import java.util.*;
import java.io.*;

public class Main {
    static int[] alphabet;
    static ArrayList<String> arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            arr = new ArrayList<>();
            alphabet = new int[26];
            String now = br.readLine();
            n = now.length();
            for (int i = 0; i<now.length(); i++) {
                alphabet[now.charAt(i) - 'a']++;
            }
            dfs(0, "");
            Collections.sort(arr);
            for (int i = 0; i<arr.size(); i++) {
                sb.append(arr.get(i) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int level, String str){
        if (level==n) {
            arr.add(str);
            return;
        }
        for (int i = 0; i<26; i++) {
            if (alphabet[i]>0) {
                alphabet[i]--;
                char c = (char)(i + 'a');
                dfs(level + 1, str + c);
                alphabet[i]++;
            }
        }
    }
}