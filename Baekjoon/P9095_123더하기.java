import java.io.*;
import java.util.*;

class P9095_123더하기 {
    static int n;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[3];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;

            answer = 0;
            dfs(0);
            bw.write(answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int sum) {
        if (sum > n) {
            return;
        }

        if (sum == n) {
            answer++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(sum + arr[i]);
        }
    }
}