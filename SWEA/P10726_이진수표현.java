import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P10726_이진수표현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer> al = new ArrayList<>();

            while (M != 0) {
                al.add(M % 2);
                M /= 2;
            }

            int size = al.size();
            boolean bl = true;

            if (size < N) {
                bl = false;
                bw.write("#" + test_case + " OFF\n");
            } else {
                for (int i = 0; i < N; i++) {
                    if (al.get(i) != 1) {
                        bl = false;
                        bw.write("#" + test_case + " OFF\n");
                        break;
                    }
                }
            }

            if (bl) {
                bw.write("#" + test_case + " ON\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}