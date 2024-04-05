import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NOTE02 {
    static int[] arr;
    static int[] lis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        arr = new int[A];
        lis = new int[A];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) arr[i] = Integer.parseInt(st.nextToken());

        int index = 0;
        for (int i = 0; i < A; i++) {
            int result = binary(arr[i], 0, index, index + 1);

            if (result == -1) lis[index++] = arr[i];
            else lis[result] = arr[i];

            for (int t = 0; t < A; t++) System.out.printf("%d ", lis[t]);
            System.out.println();
        }

        bw.write(index + "");


        bw.flush();
        bw.close();
        br.close();
    }

    public static int binary(int a, int start, int end, int size) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a <= lis[mid]) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start == size) return -1;
        else return result;
    }
}