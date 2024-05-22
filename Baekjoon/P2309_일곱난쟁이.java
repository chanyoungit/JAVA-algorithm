import java.io.*;
import java.util.*;

public class P2309_일곱난쟁이 {
    static boolean[] visited;
    static int[] arr;
    static boolean bl;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = new int[7];
        visited = new boolean[9];
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bl = false;
        dfs(0, 0, 0);

        Arrays.sort(answer);
        for (int i = 0; i < 7; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum, int start) {
        if (bl) {
            return;
        }

        if (sum > 100) {
            return;
        }

        if (depth == 7) {
            if (sum == 100) {
                int index = 0;
                for (int i = 0; i < 9; i++) {
                    if (visited[i]) {
                        answer[index] = arr[i];
                        index++;
                    }
                    bl = true;
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + arr[i], i);
                visited[i] = false;
            }
        }
    }
}