import java.io.*;
import java.util.*;

class P13023_ABCDE {
    static ArrayList<Integer>[] al;
    static int N, M;
    static boolean[] visited;
    static boolean bl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        al = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }

        bl = false;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, 0);
                visited[i] = false;
            }

            if (bl) {
                break;
            }
        }

        if (bl) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int num, int depth) {
        if (depth == 4) {
            bl = true;
            return;
        }

        for (int i : al[num]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}