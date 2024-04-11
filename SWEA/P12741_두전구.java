import java.io.*;
import java.util.StringTokenizer;

public class P12741_두전구 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            boolean[] visit = new boolean[101];
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = A; i <= B; i++) {
                visit[i] = true;
            }

            for (int i = C; i <= D; i++) {
                if (visit[i]) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                bw.write("#" + test_case + " " + cnt + "\n");
            } else {
                cnt -= 1;
                bw.write("#" + test_case + " " + cnt + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}