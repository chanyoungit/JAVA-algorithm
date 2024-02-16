import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;                             // 결과값
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] A = new char[S];                     // 문자열을 char 형태로 입력 받을 배열
        checkArr = new int[4];                // A C G T 의 조건
        myArr = new int[4];                   // 현재 나의 문자열중 A C G T 의 개수가 몇 개인지 확인하는 배열
        checkSecret = 0;                        // 조건이 몇개 총족이 되었는지 확인하는 변수

        A = br.readLine().toCharArray();            // char 형태로 문자 입력 받기
        st = new StringTokenizer(br.readLine());    // A C G T 의 조건 입력 받기
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if (checkSecret == 4)
            result++;

        for (int i = P; i < S; i++) {               // 슬라이딩 윈도우
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4)
                result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
