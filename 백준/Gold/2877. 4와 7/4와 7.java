import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        String now = tenToZero(n).replace("0", "4").replace("1", "7");
        System.out.println(now.substring(1, now.length()));
    }

    // 2진수로 변환하기
    public static String tenToZero(int num) {
        StringBuilder sb = new StringBuilder();

        while (num>=1) {
            sb.append(num%2);
            num = num/2;
        }
        return sb.reverse().toString();
    }
}