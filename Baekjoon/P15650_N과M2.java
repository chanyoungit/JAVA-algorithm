import java.io.*;
import java.util.StringTokenizer;

public class P15650_N과M2 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0, 0);

        bw.write(sb.toString() + " ");
        bw.close();
    }

    public static void dfs(int N, int M, int value, int depth) {
        if (M == depth) {
            for (int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = value; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, i + 1, depth + 1);
        }
    }
}
