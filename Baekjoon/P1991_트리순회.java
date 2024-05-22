import java.io.*;
import java.util.StringTokenizer;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class P1991_트리순회 {
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[root - 'A'] == null) {
                tree[root - 'A'] = new Node(root);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
