import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int answer = 0;

        while (end < n) {
            hash.put(arr[end], hash.getOrDefault(arr[end], 0) + 1);

            while (hash.size() > 2) {
                if (hash.get(arr[start]) == 1) {
                    hash.remove(arr[start]);
                } else {
                    hash.put(arr[start], hash.get(arr[start]) - 1);
                }
                start++;
            }

            answer = Math.max(answer, end - start + 1);
            end++;
        }

        System.out.println(answer);
    }
}