import java.io.*;
import java.util.StringTokenizer;

public class P14692_통나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int seq = i + 1;
            if (N % 2 == 0) {
                bw.write("#" + seq + " Alice\n");
            } else {
                bw.write("#" + seq + " Bob\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}