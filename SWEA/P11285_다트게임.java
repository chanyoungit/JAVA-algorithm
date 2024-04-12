import java.io.*;
import java.util.StringTokenizer;

public class P11285_다트게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            long sum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int score = 0;
                for (int j = 0; j < 10; j++) {
                    if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(arr[j], 2)) {
                        score = arr[j];
                        break;
                    }
                }

                if (score != 0) {
                    int p = 11 - score / 20;
                    sum += p;
                }
            }
            bw.write("#" + test_case + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}