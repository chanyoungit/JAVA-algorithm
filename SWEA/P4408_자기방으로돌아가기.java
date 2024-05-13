import java.io.*;
import java.util.*;

class P4408_자기방으로돌아가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int[] path = new int[201];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());

                if (arr[i][0] > arr[i][1]) {
                    int temp = arr[i][0];
                    arr[i][0] = arr[i][1];
                    arr[i][1] = temp;
                }

                int s = -1;
                int e = -1;

                if (arr[i][0] % 2 == 1) {
                    s = arr[i][0] / 2 + 1;
                } else {
                    s = arr[i][0] / 2;
                }

                if (arr[i][1] % 2 == 1) {
                    e = arr[i][1] / 2 + 1;
                } else {
                    e = arr[i][1] / 2;
                }

                for (int j = s; j <= e; j++) {
                    path[j]++;
                }
            }

            Arrays.sort(path);


            bw.write("#" + test_case + " " + path[200] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}