import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> sToE;
    static ArrayList<ArrayList<Integer>> eToS;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        sToE = new ArrayList<>();
        eToS = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            sToE.add(new ArrayList<>());
            eToS.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sToE.get(a).add(b);
            eToS.get(b).add(a);
        }

        visited = new boolean[n];
        dfs(0, x);
        int answer1 = 0;
        for (int i = 0; i<n; i++) {
            if (visited[i] && i!=x) answer1++;
        }
        visited = new boolean[n];
        dfs(1, x);
        int answer2 = 0;
        for (int i = 0; i<n; i++) {
            if (visited[i] && i!=x) answer2++;
        }
        System.out.println((n-answer1) + " " + (answer2+1));
    }

    public static void dfs(int param, int num) {
        visited[num] = true;
        if (param==0) {
            for (int i: sToE.get(num)) {
                if (!visited[i]) {
                    dfs(param, i);
                }
            }
        } else if (param==1) {
            for (int i: eToS.get(num)) {
                if (!visited[i]) {
                    dfs(param, i);
                }
            }
        }
    }
}