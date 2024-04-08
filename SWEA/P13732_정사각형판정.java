import java.io.*;
import java.util.StringTokenizer;

public class P13732_정사각형판정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int[] index = { N, N, -1, -1 };

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == '#') {
                        index[0] = Math.min(index[0], i); // 최소 x의 값
                        index[1] = Math.min(index[1], j); // 최소 y의 값
                        index[2] = Math.max(index[2], i); // 최대 x의 값
                        index[3] = Math.max(index[3], j); // 최대 y의 값
                    }
                }
            }

            boolean bl = true;
            if (index[2] - index[0] == index[3] - index[1]) {
                for (int i = index[0]; i <= index[2]; i++) {
                    for (int j = index[1]; j <= index[3]; j++) {
                        if (arr[i][j] != '#') {
                            bl = false;
                            break;
                        }
                        if (!bl)
                            break;
                    }
                }
            } else
                bl = false;

            if (bl)
                bw.write("#" + test_case + " yes\n");
            else
                bw.write("#" + test_case + " no\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}