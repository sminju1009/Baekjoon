import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] colors;

    static ArrayList<ArrayList<Integer>> arr;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            colors = new int[n+1];
            Arrays.fill(colors, -1);
            arr = new ArrayList<>();
            for (int i = 0; i<=n; i++) {
                arr.add(new ArrayList<>());
            }
            flag = true;
            for (int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.get(a).add(b);
                arr.get(b).add(a);
            }
            for (int i = 1; i<=n; i++) {
                if (colors[i]==-1) {
                    dfs(i, 0);
                }
            }

            String answer = (flag) ? "possible" : "impossible";
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int num, int color) {
        colors[num] = color;

        for (int i: arr.get(num)) {
            if (colors[i]==color) {
                flag = false;
                return;
            }
            if (colors[i]==-1) {
                dfs(i, (color+1)%2);
            }
        }

    }
}
