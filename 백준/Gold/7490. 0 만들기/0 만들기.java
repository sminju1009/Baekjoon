import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int num = Integer.parseInt(br.readLine());
            dfs(num, 1,  "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int level, String result) {
        if (level==n) {
            if (calculate(result.replaceAll(" ", ""))==0) {
                sb.append(result);
                sb.append("\n");
            }
            return;
        }

        // 공백 삽입할 때
        dfs(n, level+1, result+" "+(level+1));
        // + 넣을 때
        dfs(n, level+1, result+"+"+(level+1));
        // - 넣을 때
        dfs(n, level+1, result+"-"+(level+1));


    }

    public static int calculate(String value) {

        String op = "";
        List<String> temp = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|[+*/-]");
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            temp.add(matcher.group());
        }

        int result = Integer.parseInt(temp.get(0));

        for (int i = 1; i<temp.size(); i++) {
            if (temp.get(i).equals("+") || temp.get(i).equals("-")) {
                op = temp.get(i);
            } else {
                result = (op.equals("+")) ? result+Integer.parseInt(temp.get(i)) : result-Integer.parseInt(temp.get(i));
            }
        }
        return result;
    }
}