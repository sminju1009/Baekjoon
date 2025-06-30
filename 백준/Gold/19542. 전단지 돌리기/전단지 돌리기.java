import java.util.*;
import java.io.*;

public class Main {

    static int n, s, d;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] depth;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        depth = new int[n];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        calculateDepth(s, -1);

        int visitCount = countVisitNodes(s, -1);

        int result = (visitCount - 1) * 2;
        System.out.println(result);
    }

    public static int calculateDepth(int now, int parent) {
        int maxDepth = 0;

        for (int next : arr.get(now)) {
            if (next != parent) {
                maxDepth = Math.max(maxDepth, calculateDepth(next, now) + 1);
            }
        }

        depth[now] = maxDepth;
        return maxDepth;
    }

    public static int countVisitNodes(int now, int parent) {
        int count = 1;

        for (int next : arr.get(now)) {
            if (next != parent) {
                if (depth[next] >= d) {
                    count += countVisitNodes(next, now);
                }
            }
        }

        return count;
    }
}