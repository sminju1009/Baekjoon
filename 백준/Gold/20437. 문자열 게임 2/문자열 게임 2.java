import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int min = Integer.MAX_VALUE;
            int max = -1;
            int[] chars = new int[26];
            String str = br.readLine();
            for (int i = 0; i<str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            int k = Integer.parseInt(br.readLine());
            if (k==1) {
                sb.append("1 1" + "\n");
                continue;
            }
            for (int i = 0; i<str.length(); i++) {
                if (chars[str.charAt(i) - 'a'] >= k) {
                    int count = 1;
                    for (int j = i+1; j<str.length(); j++) {
                        if (str.charAt(i)==str.charAt(j)) count++;
                        if (count==k) {
                            max = Math.max(max, j-i+1);
                            min = Math.min(min, j-i+1);
                            break;
                        }
                    }
                }
            }

            if (max==-1 || min==Integer.MAX_VALUE) {
                sb.append(-1+"\n");
            } else {
                sb.append(min + " " + max + "\n");
            }
        }
        System.out.println(sb);
    }
}