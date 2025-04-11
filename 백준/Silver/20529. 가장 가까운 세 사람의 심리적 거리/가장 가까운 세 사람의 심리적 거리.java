import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] arr = new String[n];
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            boolean found = false;
            for (String mbti : map.keySet()) {
                if (map.get(mbti) >= 3) {
                    sb.append("0\n");
                    found = true;
                    break;
                }
            }
            if (found) continue;

            List<String> uniqueList = new ArrayList<>();
            for (String key : map.keySet()) {
                int count = Math.min(map.get(key), 3);
                for (int i = 0; i < count; i++) {
                    uniqueList.add(key);
                }
            }

            int min = Integer.MAX_VALUE;
            int size = uniqueList.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        int dist = getDistance(uniqueList.get(i), uniqueList.get(j))
                                 + getDistance(uniqueList.get(i), uniqueList.get(k))
                                 + getDistance(uniqueList.get(j), uniqueList.get(k));
                        min = Math.min(min, dist);
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    static int getDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}