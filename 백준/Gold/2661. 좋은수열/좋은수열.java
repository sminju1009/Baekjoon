import java.io.*;

public class Main {

    static int n;
    static int start = 1;
    static int end = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    public static void backtracking(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = start; i<=end; i++) {
            if (canMakeStr(str+i)) backtracking(str+i);
        }
    }

    public static boolean canMakeStr(String str) {
        for (int i = 1; i<=str.length()/2; i++) {
            String front = str.substring(str.length()-i*2, str.length()-i);
            String back = str.substring(str.length()-i, str.length());
            if (front.equals(back)) return false;
        }
        return true;
    }
}