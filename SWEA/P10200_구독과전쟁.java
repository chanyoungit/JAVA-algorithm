import java.io.*;
import java.util.*;

public class P10200_구독과전쟁 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = -1;
            int min = -1;

            if (a + b <= N) {
                min = 0;
            } else {
                min = (a + b) - N;
            }

            if (a <= b) {
                max = a;
            } else {
                max = b;
            }

            bw.write("#" + test_case + " " + max + " " + min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}