import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        HashMap<Character, Integer> temp = new HashMap<>();
        int start = 0, end = 0;

        while (end < str.length()) {
            char c = str.charAt(end);
            temp.put(c, temp.getOrDefault(c, 0) + 1);
            end++;

            while (temp.size() > n) {
                char startChar = str.charAt(start);
                temp.put(startChar, temp.get(startChar) - 1);
                if (temp.get(startChar) == 0) {
                    temp.remove(startChar);
                }
                start++;
            }

            max = Math.max(max, end - start);
        }

        System.out.println(max);
    }
}