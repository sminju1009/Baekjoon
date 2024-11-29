import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Character, Character[]> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = (st.nextToken()).charAt(0);
            char left = (st.nextToken()).charAt(0);
            char right = (st.nextToken()).charAt(0);
            tree.put(root, new Character[]{left, right});
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');

        System.out.println(sb);
    }
    public static void preorder(char root) {
        if (root!='.') {
            sb.append(root);
            preorder(tree.get(root)[0]);
            preorder(tree.get(root)[1]);
        }
    }

    public static void inorder(char root) {
        if (root!='.') {
            inorder(tree.get(root)[0]);
            sb.append(root);
            inorder(tree.get(root)[1]);
        }
    }

    public static void postorder(char root) {
        if (root!='.') {
            postorder(tree.get(root)[0]);
            postorder(tree.get(root)[1]);
            sb.append(root);
        }
    }
}