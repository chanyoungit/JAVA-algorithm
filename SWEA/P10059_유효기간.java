import java.io.*;
import java.util.*;

public class P10059_유효기간 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] ch = br.readLine().toCharArray();
            String strF = String.valueOf(ch[0]) + String.valueOf(ch[1]);
            String strS = String.valueOf(ch[2]) + String.valueOf(ch[3]);

            int intF = Integer.parseInt(strF);
            int intS = Integer.parseInt(strS);

            boolean my = MMYY(intF, intS);
            boolean ym = YYMM(intF, intS);

            if (my && ym) {
                bw.write("#" + test_case + " AMBIGUOUS\n");
            } else if (my) {
                bw.write("#" + test_case + " MMYY\n");
            } else if (ym) {
                bw.write("#" + test_case + " YYMM\n");
            } else {
                bw.write("#" + test_case + " NA\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean MMYY(int s, int e) {
        if (s < 1 || s >= 13) {
            return false;
        }

        return true;
    }

    public static boolean YYMM(int s, int e) {
        if (e < 1 || e >= 13) {
            return false;
        }

        return true;
    }
}