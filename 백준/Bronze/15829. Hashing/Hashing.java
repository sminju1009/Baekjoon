import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int prime = 1234567891;
        long r = 1;
        String s = br.readLine();
        long answer = 0;

        for (int i = 0; i<n; i++) {
            answer += ((s.charAt(i)-'a'+1)*r)%prime;
            r = (r*31)%prime;
        }
        System.out.println(answer%prime);
    }
}