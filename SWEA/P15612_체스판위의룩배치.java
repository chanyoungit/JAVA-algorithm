import java.io.*;
import java.util.StringTokenizer;

public class P15612_체스판위의룩배치 {
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) { // 테스트 케이스
            visit = new boolean[8];
            boolean bl = true;
            int sum = 0;

            for (int j = 0; j < 8; j++) { // '.' , 'O' 입력 받기
                String str = br.readLine();
                char[] ch = str.toCharArray();
                int count = 0;
                int index = 0;

                for (int k = 0; k < 8; k++) { // 'O' 인지 확인
                    if (ch[k] == 'O') {
                        count++;
                        index = k;
                    }

                }
                if (count == 1) {
                    sum += 1;
                    bl = isPrime(index);
                } else {
                    bl = false;
                }
            }

            int seq = i + 1;
            if (bl && sum == 8)
                bw.write("#" + seq + " yes\n");
            else
                bw.write("#" + seq + " no\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPrime(int y) {
        if (!visit[y]) {
            visit[y] = true;
            return true;
        } else {
            return false;
        }
    }
}