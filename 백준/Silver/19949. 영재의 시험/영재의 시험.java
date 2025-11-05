import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;
    static int[] arr = new int[10];
    static int[] youngjae = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int level) {
        if (level==10) {
            int cnt = 0;
            for (int i = 0; i<10; i++) {
                if (arr[i]==youngjae[i]) cnt++;
            }
            if (cnt>=5) count++;
            return;
        }

        for (int i = 1; i<=5; i++) {
            if (level>=2 && youngjae[level-1]==i && youngjae[level-2]==i) continue;
            youngjae[level] = i;
            dfs(level+1);
        }
    }
}