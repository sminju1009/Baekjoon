import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon1 = new HashMap<>();
        HashMap<String, Integer> pokemon2 = new HashMap<>();
        int m = Integer.parseInt(st.nextToken());
        // n개의 줄에 포켓몬 입력이 들어옴
        for (int i = 0; i<n; i++) {
            String name = br.readLine();
            pokemon1.put(i+1, name);
            pokemon2.put(name, i+1);
        }
        // 정답 맞추기
        for (int i = 0; i<m; i++) {
            String name = br.readLine();
            if (pokemon2.containsKey(name)) {
                sb.append(pokemon2.get(name) + "\n");
            } else {
                int number = Integer.parseInt(name);
                sb.append(pokemon1.get(number) + "\n");

            }
        }
        System.out.println(sb);
    }
}