import java.io.*;

public class P10804_문자열의거울상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();

            for (int i = 0; i < arr.length; i++) {
                arr[i] = swap(arr[i]);
                sb.append(arr[i] + "");
            }

            bw.write("#" + test_case + " " + sb.reverse().toString() + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static char swap(char ch) {
        switch (ch) {
            case 'b':
                return 'd';
            case 'd':
                return 'b';
            case 'p':
                return 'q';
            default:
                return 'p';
        }
    }
}