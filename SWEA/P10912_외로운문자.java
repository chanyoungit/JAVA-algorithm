import java.io.*;
import java.util.Arrays;

public class P10912_외로운문자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();
            boolean[] visit = new boolean[arr.length];

            for (int i = 0; i < arr.length - 1; i++) {
                if (!visit[i]) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] == arr[j]) {
                            visit[i] = true;
                            visit[j] = true;
                            break;
                        }
                    }
                }
            }

            String str = "";
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!visit[i]) {
                    str += String.valueOf(arr[i]);
                    count++;
                }
            }

            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            str = "";
            for (int i = 0; i < ch.length; i++) {
                str += String.valueOf(ch[i]);
            }

            if (count == 0) {
                bw.write("#" + test_case + " Good\n");
            } else {
                bw.write("#" + test_case + " " + str + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}