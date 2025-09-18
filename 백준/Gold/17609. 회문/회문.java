import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc--> 0) {
            String str = br.readLine();
            sb.append(pointer(str, 0, str.length()-1, 0) + "\n");
        }
        System.out.println(sb);
    }

    public static int pointer(String str, int start, int end, int level) {
        if (level>=2) return 2;

        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                int answer = Math.min(pointer(str, start+1, end, level+1), pointer(str, start, end-1, level+1));
                return answer;
            }
        }

        return level;
    }
}