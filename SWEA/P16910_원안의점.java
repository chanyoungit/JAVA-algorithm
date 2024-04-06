import java.io.*;
import java.util.StringTokenizer;

public class P16910_원안의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int range = (int) Math.pow(N, 2);

            int count = 0;
            for (int a = -N; a <= N; a++) {
                for (int b = -N; b <= N; b++) {
                    int value = (int) Math.pow(a, 2) + (int) Math.pow(b, 2);
                    if (value <= range)
                        count++;
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