import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int strlen = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int result = 0;
        for (int i = 1; i<strlen-1;) {
            if (str.charAt(i-1)=='I' && str.charAt(i)=='O' && str.charAt(i+1)=='I') {
                count++;
                if (count==n) {
                    result++;
                    count--;
                }
                i+=2;
            } else {
                count = 0;
                i++;
            }
        }
        System.out.println(result);
    }
}