import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i<=n; i++) {
            int num = i;
            while (num % 5 == 0) {
                count++;
                num/=5;
            }
        }
        System.out.println(count);
    }
}