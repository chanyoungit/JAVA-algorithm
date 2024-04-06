import java.io.*;
import java.util.StringTokenizer;

public class P16800_구구단걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            long count = Long.MAX_VALUE;

            for (int j = 1; j <= Math.sqrt(N); j++) {
                if (N % j == 0) {
                    long now = N / j + j - 2;
                    if (count > now)
                        count = now;
                }
            }

            int seq = i + 1;
            bw.write("#" + seq + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}