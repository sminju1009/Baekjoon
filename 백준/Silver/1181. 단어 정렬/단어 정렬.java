import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> arr = new HashSet<>();
        for (int i = 0; i<n; i++) {
            arr.add(br.readLine());
        }

        // SET을 list로 변환
        List<String> list = new ArrayList<>(arr);
        // 람다식 이용해서 단어 정렬
        list.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for (String word: list) {
            System.out.println(word);
        }

    }
}