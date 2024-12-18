import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] numbers;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) + 1;
        arr = new char[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n-1; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        numbers = new int[10];
        for (int i = 0; i<10; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i<10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, 0, i+"");
            visited[i] = false;
        }
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }
    public static void dfs(int start, int cnt, String word) {
        if (word.length() == n) {
            answer.add(word);
            return;
        }
        for (int i = 0; i<10; i++) {
            if (!visited[i]) {
                char tmp = arr[cnt];
                if (tmp=='>') {
                    if (start>i) {
                        visited[i] = true;
                        dfs(i, cnt+1, word+i);
                        visited[i] = false;
                    }
                } else {
                    if (start<i) {
                        visited[i] = true;
                        dfs(i, cnt+1, word+i);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}