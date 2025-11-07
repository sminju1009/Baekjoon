import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] time;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n+1];
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int past = Integer.parseInt(st.nextToken());
            for (int j = 0; j<past; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr.get(i).add(a);
            }
        }
        for (int i = 1; i<=n; i++) {
            int temp = 0;
            for (int a: arr.get(i)) {
                temp = Math.max(temp, time[a]);
            }
            time[i] += temp;
            answer = Math.max(answer, time[i]);
        }
        System.out.println(answer);
    }
}