import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14361_숫자가같은배수 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String N = br.readLine();
            char[] chN = N.toCharArray();
            Arrays.sort(chN);

            int seq = i + 1;
            int k = 2;
            while (true) {
                long NX = Long.parseLong(N) * k;
                if (String.valueOf(NX).length() > String.valueOf(N).length()) {
                    bw.write("#" + seq + " impossible\n");
                    break;
                }

                char[] chNX = String.valueOf(NX).toCharArray();
                Arrays.sort(chNX);
                if (Arrays.equals(chN, chNX)) {
                    bw.write("#" + seq + " possible\n");
                    break;
                }
                k++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}