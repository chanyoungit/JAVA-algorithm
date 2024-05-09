import java.io.*;
import java.util.*;

class P5215_햄버거다이어트 {
    static int N;
    static int L;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            visited = new boolean[N];
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            dfs(0, 0, 0);

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int score, int cal) {
        if (cal > L) {
            return;
        }

        if (idx == N) {
            answer = Math.max(answer, score);
            return;
        }

        dfs(idx + 1, score + arr[idx][0], cal + arr[idx][1]);
        dfs(idx + 1, score, cal);
    }
}