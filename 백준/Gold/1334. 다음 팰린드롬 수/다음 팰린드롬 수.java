import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine().trim();

        System.out.println(nextPalindrome(n));
    }

    static String nextPalindrome(String n) {
        int len = n.length();

        if (n.chars().allMatch(c -> c == '9')) {
            StringBuilder sb = new StringBuilder("1");
            for (int i = 0; i < len - 1; i++) sb.append("0");
            sb.append("1");
            return sb.toString();
        }

        boolean odd = (len % 2 == 1);
        String front = n.substring(0, len / 2);
        String mid = odd ? n.substring(len / 2, len / 2 + 1) : "";
        String mirror = makePalindrome(front, mid, odd);

        if (compare(mirror, n) > 0) return mirror;

        if (odd) {
            String plus = addOne(front + mid);
            String newFront = plus.substring(0, plus.length() - 1);
            String newMid = plus.substring(plus.length() - 1);
            return makePalindrome(newFront, newMid, true);
        } else {
            String plus = addOne(front);
            return makePalindrome(plus, "", false);
        }
    }

    static String makePalindrome(String front, String mid, boolean odd) {
        StringBuilder sb = new StringBuilder();
        sb.append(front);
        if (odd) sb.append(mid);
        sb.append(new StringBuilder(front).reverse());
        return sb.toString();
    }

    static int compare(String a, String b) {
        if (a.length() != b.length()) return a.length() - b.length();
        return a.compareTo(b);
    }

    static String addOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == '9') {
            sb.setCharAt(i, '0');
            i--;
        }
        if (i >= 0) {
            sb.setCharAt(i, (char)(sb.charAt(i) + 1));
        } else {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
