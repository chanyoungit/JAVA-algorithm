import java.io.*;
import java.util.StringTokenizer;

public class P13732_정사각형판정 {
    static boolean[][] visit;
    static boolean[][] visit2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];
            visit2 = new boolean[N][N];
            boolean bl = true;
            int count = 0;

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                char[] ch = str.toCharArray();

                for (int k = 0; k < N; k++) {
                    if (ch[k] == '#') {
                        visit[j][k] = true;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visit[j][k] && !visit2[j][k]) {
                        if(bl){
                            bl = DFS(j, k);
                            count++;
                        }
                    }
                }
            }
            int seq = i + 1;
            if (bl && count == 1) {
                bw.write("#" + seq + " yes\n");
            } else {
                bw.write("#" + seq + " no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean DFS(int a, int b) {
        int xcount = 0;

        int bm = b + 1;
        while (true) {
            if (bm < N) {
                if (!visit[a][bm]) {
                    break;
                }
                visit2[a][bm] = true;
                bm++;
                xcount++;
            } else
                break;

        }

        for (int i = a + 1; i <= a + xcount; i++) {
            for (int j = b; j <= b + xcount; j++) {
                System.out.println("i = " + i + " j = " + j);
                if (!visit[i][j]) {
                    return false;
                }
                visit2[i][j] = true;
            }
        }
        return true;
    }
}