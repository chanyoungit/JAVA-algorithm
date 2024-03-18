import java.io.*;
import java.util.StringTokenizer;

public class P15649_N과M1 {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 숫자 몇까지
        int M = Integer.parseInt(st.nextToken());   // 출력 개수

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
        bw.write(sb.toString() + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int N, int M, int depth) {
        if (M == depth) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
