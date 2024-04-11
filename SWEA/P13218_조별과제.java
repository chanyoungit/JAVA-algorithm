import java.io.*;

public class P13218_조별과제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int result = N / 3;

            bw.write("#" + test_case + " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}