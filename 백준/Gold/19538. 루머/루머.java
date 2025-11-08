import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] answer;
    static int[] cnt;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        Arrays.fill(answer, -1);
        cnt = new int[n];
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a==0) break;
                a = a-1;
                arr.get(i).add(a);
            }
        }
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ;i<num; i++) {
            int a = Integer.parseInt(st.nextToken()) - 1;
            answer[a] = 0;
            q.add(a);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int a: arr.get(curr)) {
                if (answer[a]!=-1) continue;
                cnt[a]++;
                int size = arr.get(a).size();
                if (cnt[a]*2 >= size) {
                    answer[a] = answer[curr] + 1;
                    q.add(a);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}