import java.util.*;
import java.io.*;

public class Main {

    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int answer = lcs(s1, s2);
        System.out.println(answer);
        if (!result.equals("")) {
            System.out.println(result);
        }
    }

    public static int lcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] arr = new int[len1+1][len2+1];

        for (int i = 1; i<len1+1; i++) {
            for (int j = 1; j<len2+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = len1;
        int j = len2;
        while (i>0 && j>0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (arr[i-1][j] >= arr[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        result = sb.reverse().toString();
        return arr[len1][len2];
    }
}