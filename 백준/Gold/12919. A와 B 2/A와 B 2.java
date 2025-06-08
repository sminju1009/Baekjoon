import java.io.*;

public class Main{
    static String a, b;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        dfs(b);
        System.out.println(answer);
    }

    public static void dfs(String str) {

        if (str.length()==a.length()) {
            if (str.equals(a)) {
                answer = 1;
            }
            return;
        }

        if (str.startsWith("B")) {
            dfs(new StringBuilder(str.substring(1)).reverse().toString());
        }

        if (str.endsWith("A")) {
            dfs(str.substring(0, str.length()-1));
        }

    }
}