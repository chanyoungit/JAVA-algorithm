import java.io.*;
import java.util.StringTokenizer;

public class P10993_군주제와공화제 {
    static char[] ch;
    static int[] index;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][3];
            ch = new char[N];
            index = new int[N];
            for (int i = 0; i < N; i++) {
                index[i] = i;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        double power = arr[j][2]
                                / ((Math.pow(arr[i][0] - arr[j][0], 2)) + (Math.pow(arr[i][1] - arr[j][1], 2)));
                        if (arr[i][2] < power) {
                            count++;
                            index[i] = index[j];
                        }
                    }
                }
                if (count == 0) {
                    ch[i] = 'K';
                } else if (count == 1) {
                    ch[i] = (char) (index[i] + '0');
                } else {
                    ch[i] = 'D';
                }
            }

            for (int i = 0; i < N; i++) {
                if (ch[i] != 'K' && ch[i] != 'D') {
                    ch[i] = find(ch[i] - '0');
                }
            }

            for (int i = 0; i < N; i++) {
                if (ch[i] != 'K' && ch[i] != 'D') {
                    ch[i] += 1;
                }
            }

            bw.write("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                bw.write(ch[i] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static char find(int a) {
        if (ch[a] == 'K' || ch[a] == 'D') {
            return (char) (a + '0');
        } else {
            return find(ch[a] - '0');
        }
    }
}