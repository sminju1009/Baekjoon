import java.util.*;
import java.io.*;

public class Main {
    static int l, c;
    static String[] arr;
    static String[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static String[] isTrue = new String[]{"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[c];
        result = new String[l];
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<c; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);

    }
    public static void dfs(int order, int level) {
        if (level==l) {
            if (isValid()) {
                for (int i = 0; i<l; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = order; i<c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[level] = arr[i];
                dfs(i+1, level+1);
                visited[i] = false;
                result[level] = "";
            }
        }
    }
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (String x : result) {
            if (x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u")) {
                mo++;
            } else {
                ja++;
            }
        }

        return mo>=1 && ja>=2;
    }
}