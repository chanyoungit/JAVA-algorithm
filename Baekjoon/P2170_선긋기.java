import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2170_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int min = arr[0][0];
        int max = arr[0][1];
        int len = max - min;
        for (int i = 0; i < N; i++) {
            if (min <= arr[i][0] && max >= arr[i][1]) continue;
            else if (arr[i][0] < max && arr[i][1] > max) {
                len += arr[i][1] - max;
            } else if (arr[i][0] >= max) {
                len += arr[i][1] - arr[i][0];
            }
            max = arr[i][1];
            min = arr[i][0];
        }
        bw.write(len + "");
        bw.flush();
        bw.close();
        br.close();
    }
}