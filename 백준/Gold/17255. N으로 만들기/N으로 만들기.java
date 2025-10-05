import java.util.*;
import java.io.*;

public class Main {
    static String str;
    static int n;
    static HashMap<Character, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        n = str.length();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        dfs(0, map, "", "");
        System.out.println(set.size());
    }

    public static void dfs(int level, HashMap<Character, Integer> HashMap, String string, String answer) {
        if (level == n && string.equals(str)) {
            set.add(answer);
            return;
        }

        for (char i : new ArrayList<>(HashMap.keySet())) {
            HashMap.put(i, HashMap.get(i) - 1);
            if (HashMap.get(i) == 0) {
                HashMap.remove(i);
            }

            dfs(level+1, HashMap, string+i, answer+string+i);
            dfs(level+1, HashMap, i+string, answer+i+string);

            if (HashMap.containsKey(i)) {
                HashMap.put(i, HashMap.get(i) + 1);
            } else {
                HashMap.put(i, 1);
            }
        }
    }
}