import java.io.*;
import java.util.StringTokenizer;

public class P11856_반반 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] visit = new boolean[4];
            char[] ch = br.readLine().toCharArray();

            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < ch.length; i++) {
                if (!visit[i]) {
                    count1++;
                    visit[i] = true;
                    for (int j = i + 1; j < ch.length; j++) {
                        if (ch[i] == ch[j]) {
                            count2++;
                            visit[j] = true;
                        }
                    }
                }
            }

            if (count1 == 2 && count2 == 2) {
                bw.write("#" + test_case + " Yes\n");
            } else {
                bw.write("#" + test_case + " No\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}