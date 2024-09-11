import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> result = new LinkedList<>();
        String a = br.readLine();
        String[] b = a.split("-");

        for (int i = 0; i < b.length; i++) {
            String[] c = b[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < c.length; j++) {
                int d = Integer.parseInt(c[j]);
                sum += d;
            }
            result.add(sum);
        }
        
        int answer = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            answer -= result.get(i);
        }

        System.out.println(answer);
    }
}