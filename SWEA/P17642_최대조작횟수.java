import java.io.*;
import java.util.StringTokenizer;

public class P17642_최대조작횟수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            int seq = i + 1;

            if (A > B)
                bw.write("#" + seq + " -1\n");
            else {
                long count = 0;
                long gap = B - A;

                if (gap == 0)
                    bw.write("#" + seq + " 0\n");
                else if (gap == 1)
                    bw.write("#" + seq + " -1\n");
                else {
                    count += gap / 2;
                    bw.write("#" + seq + " " + count + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}