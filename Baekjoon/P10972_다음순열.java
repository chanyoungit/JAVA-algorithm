import java.io.*;
import java.util.*;

class P10972_다음순열 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (isPrime()) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            bw.write(sb + "");
        } else {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPrime() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] > arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] > arr[j]) {
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return true;
    }
}
