import java.io.*;
import java.util.StringTokenizer;

public class P12004_구구단1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            boolean bl = false;
            for (int i = 1; i <= 9; i++) {
                if (N % i == 0) {
                    if (N / i > 9) {
                        continue;
                    }
                    bl = true;
                    break;
                }
            }
            if (bl) {
                bw.write("#" + test_case + " Yes\n");
            } else {
                bw.write("#" + test_case + " No\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}