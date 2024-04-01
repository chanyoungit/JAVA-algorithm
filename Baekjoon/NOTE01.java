import java.io.*;
import java.util.StringTokenizer;

public class NOTE01 {
    static int[] arr;
    static boolean[] visit1;
    static boolean[] visit2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit1 = new boolean[N + 1];
        visit2 = new boolean[N + 1];

        dfs1(N, M, 0);
        bw.write(sb.toString() + "");

        bw.close();
    }

    public static void dfs1(int N, int M, int depth) {
        if (M == depth) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit1[i]) {
                visit1[i] = true;
                arr[depth] = i;
                dfs2(N, M, depth + 1);
                visit1[i] = false;
            }
        }
    }

    public static void dfs2(int N, int M, int depth) {

    }
}