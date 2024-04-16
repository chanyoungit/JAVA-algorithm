import java.io.*;
import java.util.StringTokenizer;

public class P10570_제곱팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sbI = new StringBuilder();
        StringBuilder sbK = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int i = 1;
            int k = i;
            while (k < A) {
                i++;
                k = i * i;
            }

            int count = 0;
            while (k <= B) {
                String strI = sbI.append(i).reverse().toString();
                String strK = sbK.append(k).reverse().toString();

                if (strI.equals(String.valueOf(i)) && strK.equals(String.valueOf(k))) {
                    count++;
                }

                sbI.setLength(0);
                sbK.setLength(0);

                i++;
                k = i * i;
            }

            bw.write("#" + test_case + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}