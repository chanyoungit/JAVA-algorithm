import java.io.*;
import java.util.StringTokenizer;

public class P15758_무한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());

            String S = st.nextToken();
            String T = st.nextToken();

            int lenS = S.length();
            int lenT = T.length();

            int seq = i + 1;
            if (lenS == lenT) {
                if (S.equals(T))
                    bw.write("#" + seq + " yes\n");
                else
                    bw.write("#" + seq + " no\n");
            } else {
                String strS = "";
                String strT = "";

                for (int j = 0; j < lenT; j++) {
                    strS += S;
                }

                for (int j = 0; j < lenS; j++) {
                    strT += T;
                }

                if (strS.equals(strT))
                    bw.write("#" + seq + " yes\n");
                else
                    bw.write("#" + seq + " no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}