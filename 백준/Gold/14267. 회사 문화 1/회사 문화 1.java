import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a!=-1) {
                arr.get(a-1).add(i);
            }
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            result[person] += w;
        }

        dfs(0);

        for (int i = 0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void dfs(int now) {
        for (int i: arr.get(now)) {
            result[i] += result[now];
            dfs(i);
        }
    }
}