import java.io.*;
import java.util.*;

public class P10580_전봇대 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });

            int answer = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (arr[i][1] > arr[j][1]) {
                        answer++;
                    }
                }
            }

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}