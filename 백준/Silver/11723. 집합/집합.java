import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];
        for (int i = 0; i<m; i++) {
            String a = br.readLine();
            String[] b = a.split(" ");
            if (b[0].equals("add")) {
                if (!arr[Integer.parseInt(b[1])])  {
                    arr[Integer.parseInt(b[1])] = true;
                }
            } else if (b[0].equals("remove")) {
                if (arr[Integer.parseInt(b[1])]) {
                    arr[Integer.parseInt(b[1])] = false;
                }
            } else if (b[0].equals("check")) {
                if (arr[Integer.parseInt(b[1])]) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (b[0].equals("toggle")) {
                if (arr[Integer.parseInt(b[1])]) {
                    arr[Integer.parseInt(b[1])] = false;
                } else {
                    arr[Integer.parseInt(b[1])] = true;
                }
            } else if (b[0].equals("all")) {
                for (int j = 1; j<=20; j++) {
                    arr[j] = true;
                }
            } else if (b[0].equals("empty")) {
                for (int j = 1; j<=20; j++) {
                    arr[j] = false;
                }
            }

        }
        System.out.println(sb);
    }
}