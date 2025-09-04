import java.io.*;

public class Main {

    public static String regex = "[A-F]?A+F+C+[A-F]?$";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            String str = br.readLine();
            sb.append(str.matches(regex) ? "Infected!\n" : "Good\n");
        }
        System.out.println(sb);
    }
}