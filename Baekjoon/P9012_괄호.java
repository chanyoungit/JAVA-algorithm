import java.io.*;
import java.io.*;

public class P9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        boolean bl;

        for (int i = 0; i < T; i++) {
            bl = true;
            char[] arr = br.readLine().toCharArray();
            int start = 0;
            int end = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    start++;
                } else {
                    end++;
                }

                if (start < end) {
                    bl = false;
                    break;
                }
            }

            if (!bl || start != end) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}