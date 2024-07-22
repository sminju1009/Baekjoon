import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String a = br.readLine();
            StringBuffer change = new StringBuffer(a);
            String b = change.reverse().toString();
            if (a.equals("0")) {
                break;
            }
            if (a.equals(b)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}