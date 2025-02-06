import java.util.*;
import java.io.*;

public class Main {

    static boolean isTrue;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t<tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new int[v];
            Arrays.fill(arr, -1);
            array = new ArrayList<>();
            for (int i = 0; i<v; i++) {
                array.add(new ArrayList<>());
            }
            isTrue = true;
            for (int i = 0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                array.get(start).add(end);
                array.get(end).add(start);
            }
            for (int i = 0; i<v; i++) {
                binaryGraph(i);
            }
            System.out.println((isTrue) ? "YES" : "NO");
        }
    }

    public static void binaryGraph(int n) {
        if (!isTrue) return;
        if (arr[n] == -1) arr[n] = 0;
        for (int now: array.get(n)) {
            if (arr[now]==-1) {
                arr[now] = (arr[n] + 1)%2;
                binaryGraph(now);
            }
            else {
                if (arr[now] == arr[n]) {
                    isTrue = false;
                    return;
                }
            }
        }
    }
}