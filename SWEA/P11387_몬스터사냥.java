import java.io.*;
import java.util.StringTokenizer;

public class P11387_몬스터사냥 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            long result = 0;
            for (int i = 0; i < N; i++) {
                result += D * (1 + i * L * 0.01);
            }
            bw.write("#" + test_case + " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}