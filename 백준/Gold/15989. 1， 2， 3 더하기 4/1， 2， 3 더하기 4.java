import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int arr[] = new int[10001];
        for (int i = 0; i<10001; i++) {
            arr[i] = 1;
        }
        for (int i = 2; i<10001; i++) {
            arr[i] += arr[i-2];
        }
        for (int i = 3; i<10001; i++) {
            arr[i] += arr[i-3];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(arr[a]);
        }
    }
}