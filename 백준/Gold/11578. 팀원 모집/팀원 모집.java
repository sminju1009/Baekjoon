import java.util.*;
import java.io.*;

public class Main {

    static boolean[] solved; 
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        for (int i = 0; i<m; i++) {
            arr.add(new ArrayList<>());
        }
        solved = new boolean[n];
        visited = new boolean[m];
        for (int i = 0 ;i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            for (int j = 0; j<p; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                arr.get(i).add(a);
            }
        }
        dfs(0, 0);
        if (answer==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int people, int problems) {
        if (problems==n) {
            answer = Math.min(answer, people);
            return;
        }
        if (people>=answer) return;
        if (people==m) return;

        for (int i = 0; i<m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int temp = problems;
                ArrayList<Integer> tempArr = new ArrayList<>();
                for (int j: arr.get(i)) {
                    if (!solved[j]) {
                        tempArr.add(j);
                        temp++;
                        solved[j] = true;
                    }
                }
                dfs(people+1, temp);
                visited[i] = false;
                for (int j: tempArr) {
                    solved[j] = false;
                }
            }
        }
    }
}