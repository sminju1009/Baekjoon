import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        ArrayList<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sumList.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sumList);

        for (int k = n - 1; k >= 0; k--) {
            for (int z = 0; z < n; z++) {
                int target = arr[k] - arr[z];
                if (Collections.binarySearch(sumList, target) >= 0) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}