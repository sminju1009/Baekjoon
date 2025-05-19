import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<total; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (map.containsKey(student)) {
                map.put(student, map.get(student) + 1);
            } else {
                if (map.size() == n) {
                    int id = map.entrySet().stream().min(Map.Entry.comparingByValue())
                            .get().getKey();
                    map.remove(id);
                }
                map.put(student, 1);
            }
        }
        map.keySet().stream().sorted().forEach(id -> System.out.print(id + " "));
    }
}