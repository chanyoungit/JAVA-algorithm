import java.io.*;
import java.util.*;

public class P1244_최대상금 {
    static int chance;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            chance = Integer.parseInt(st.nextToken());
            if (ch.length < chance) {
                chance = ch.length;
            }
            answer = 0;
            dfs(ch, 0);
            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(char[] ch, int depth) {
        if (depth >= chance) {
            String str = "";
            for (int i = 0; i < ch.length; i++) {
                str += ch[i];
            }

            answer = Math.max(answer, Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;

                dfs(ch, depth + 1);

                char temp1 = ch[i];
                ch[i] = ch[j];
                ch[j] = temp1;
            }
        }
    }
}