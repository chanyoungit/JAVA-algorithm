import java.io.*;
import java.util.StringTokenizer;

public class P11445_무한사전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String P = br.readLine();
            String Q = br.readLine();

            String Pa = P + "a";
            if (Pa.equals(Q)) {
                bw.write("#" + test_case + " N\n");
            } else {
                bw.write("#" + test_case + " Y\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}