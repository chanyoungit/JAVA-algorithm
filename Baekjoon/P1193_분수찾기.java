import java.util.*;
import java.io.*;

public class P1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int cnt = 0;
        int index = 0;

        boolean bl = false;
        while (true) {
            int s = start;
            int e = end;

            for (int i = 1; i <= end; i++) {
                cnt++;
                if (cnt == X) {
                    if (index % 2 == 1) {
                        bw.write(s + "/" + e + "\n");
                    } else {
                        bw.write(e + "/" + s + "\n");
                    }
                    bl = true;
                    break;
                }
                s++;
                e--;
            }
            if (bl) {
                break;
            }
            end++;
            if (index == 0) {
                index = 1;
            } else {
                index = 0;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}