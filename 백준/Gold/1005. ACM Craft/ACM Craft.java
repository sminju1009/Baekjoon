import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            ArrayList<HashSet<Integer>> array = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                array.add(new HashSet<>());
            }
            int[] result = new int[n];
            int[] inDegree = new int[n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;

                if (!array.get(start).contains(end)) {
                    array.get(start).add(end);
                    inDegree[end]++;
                }
            }

            int w = Integer.parseInt(br.readLine()) - 1;
            
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                result[i] = arr[i];
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : array.get(current)) {
                    result[next] = Math.max(result[next], result[current] + arr[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            System.out.println(result[w]);
        }
    }
}