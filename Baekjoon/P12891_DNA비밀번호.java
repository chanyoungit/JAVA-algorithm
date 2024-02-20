import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int[] check = new int[4];
    static int[] myCheck = new int[4];
    static int checkSecret = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());

        String str = br.readLine();
        char[] ch = new char[S];
        ch = str.toCharArray();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st2.nextToken());
            if (check[i] == 0) checkSecret++;
            myCheck[i] = 0;
        }

        for (int i = 0; i < P; i++)
            add(ch[i]);
        if (checkSecret == 4) count++;

        int start = 0;
        int end = P;
        while (end < S) {
            remove(ch[start]);
            add(ch[end]);
            if (checkSecret == 4) count++;
            start++;
            end++;
        }
        System.out.println(count);
    }

    public static void add(char c) {
        switch (c) {
            case 'A':
                myCheck[0]++;
                if (myCheck[0] == check[0]) checkSecret++;
                break;
            case 'C':
                myCheck[1]++;
                if (myCheck[1] == check[1]) checkSecret++;
                break;
            case 'G':
                myCheck[2]++;
                if (myCheck[2] == check[2]) checkSecret++;
                break;
            case 'T':
                myCheck[3]++;
                if (myCheck[3] == check[3]) checkSecret++;
                break;
        }
    }

    public static void remove(char c) {
        switch (c) {
            case 'A':
                if (myCheck[0] == check[0]) checkSecret--;
                myCheck[0]--;
                break;
            case 'C':
                if (myCheck[1] == check[1]) checkSecret--;
                myCheck[1]--;
                break;
            case 'G':
                if (myCheck[2] == check[2]) checkSecret--;
                myCheck[2]--;
                break;
            case 'T':
                if (myCheck[3] == check[3]) checkSecret--;
                myCheck[3]--;
                break;
        }
    }
}