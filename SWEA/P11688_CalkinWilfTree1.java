import java.io.*;
import java.util.StringTokenizer;

public class P11688_CalkinWilfTree1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();

            int a = 1;
            int b = 1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'L') {
                    b += a;
                } else {
                    a += b;
                }
            }

            bw.write("#" + test_case + " " + a + " " + b + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}