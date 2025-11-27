import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int num, level;

        public Pair (int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    static TreeSet<Pair> tree = new TreeSet<>((o1, o2) -> {
        if (o1.level == o2.level) {
            return o1.num - o2.num;
        }
        return o1.level - o2.level;
    });

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            tree.add(new Pair(num, level));
            map.put(num, level);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    tree.remove(new Pair(num, map.get(num)));
                }
                tree.add(new Pair(num, level));
                map.put(num, level);
            } else if (command.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    tree.remove(new Pair(num, map.get(num)));
                    map.remove(num);
                }
            } else if (command.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    sb.append(tree.last().num).append("\n");
                } else if (num == -1) {
                    sb.append(tree.first().num).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}