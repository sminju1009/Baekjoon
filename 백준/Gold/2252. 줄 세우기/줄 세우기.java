import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            array.add(new ArrayList<>());
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            array.get(a).add(b);
            arr[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            if (arr[i]==0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now+1 + " ");
            ArrayList<Integer> list = array.get(now);
            for (int i = 0; i<list.size(); i++) {
                int temp = list.get(i);
                arr[temp]--;
                if (arr[temp]==0) {
                    q.offer(temp);
                }
            }
        }
        System.out.println(sb);
    }
}