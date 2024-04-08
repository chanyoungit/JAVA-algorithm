import java.io.*;
import java.util.StringTokenizer;

public class P14413_격자판칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                char[] ch = str.toCharArray();

                for (int k = 0; k < ch.length; k++) {
                    if (ch[k] == '#') {
                        arr[j][k] = 0;
                    } else if (ch[k] == '.') {
                        arr[j][k] = 1;
                    } else {
                        arr[j][k] = -1;
                    }
                }
            }

            int value = -1;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] != -1) {
                        value = arr[j][k];
                        break;
                    }
                    if (value != -1)
                        break;
                }
            }


            boolean bl = true;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] != value && arr[j][k] != -1) {
                        bl = false;
                        break;
                    }
                    value = (value + 1) % 2;
                }
                if (M % 2 == 0) {
                    value = (value + 1) % 2;
                }
            }

            int seq = i + 1;
            if (bl) {
                bw.write("#" + seq + " possible\n");
            } else {
                bw.write("#" + seq + " impossible\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}