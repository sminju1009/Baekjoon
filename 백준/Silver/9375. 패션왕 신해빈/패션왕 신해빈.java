import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, HashSet<String>> clothes = new HashMap<>();
            for (int j = 0; j<n; j++) {
                String combinations = br.readLine();
                String[] combi = combinations.split(" ");
                // combi0 = Hashset 부분
                clothes.putIfAbsent(combi[1], new HashSet<>());
                clothes.get(combi[1]).add(combi[0]);
            }
            int[] cases = new int[clothes.size()];
            int index = 0;
            for (String key: clothes.keySet()) {
                int size = clothes.get(key).size();
                cases[index] = size;
                index++;
            }
            int result = 1;
            for (int j = 0; j<cases.length; j++) {
                result *= cases[j]+1;
            }
            System.out.println(result-1);
        }
    }
}