import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int flag = 1; // 빅O 정의 만족하는지 표현할 flag(불만족시 0, 만족시 1)

        for (int i = n0; i<101; i++) {
            if (a1*i+a0>i*c) {
                flag = 0;
                break;
            }
        }
        System.out.println(flag);
    }
}