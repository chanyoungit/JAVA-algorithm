import java.io.*;
import java.util.*;

public class P2309_일곱난쟁이 {
    //    static boolean[] visited;
    static int[] arr;
//    static boolean bl;
//    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        answer = new int[7];
//        visited = new boolean[9];
        arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int x = -1;
        int y = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == x || i == y) {
                continue;
            }

            bw.write(arr[i] + "\n");
        }

//        bl = false;
//
//        for (int i = 0; i < 3; i++) {
//            visited[i] = true;
//            dfs(1, arr[i], i);
//            visited[i] = false;
//        }
//
//        Arrays.sort(answer);
//        for (int i = 0; i < 7; i++) {
//            bw.write(answer[i] + "\n");
//        }

        bw.flush();
        bw.close();
        br.close();
    }

//    public static void dfs(int depth, int sum, int start) {
//        if (bl) {
//            return;
//        }
//
//        if (sum > 100) {
//            return;
//        }
//
//        if (depth == 7) {
//            if (sum == 100) {
//                int index = 0;
//                for (int i = 0; i < 9; i++) {
//                    if (visited[i]) {
//                        answer[index] = arr[i];
//                        index++;
//                    }
//                    bl = true;
//                }
//            }
//            return;
//        }
//
//        for (int i = start + 1; i < 9; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                dfs(depth + 1, sum + arr[i], start);
//                visited[i] = false;
//            }
//        }
//    }
}
