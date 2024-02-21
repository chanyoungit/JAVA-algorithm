import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수2 {
    static int N;
    static int K;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        sorted = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        mergeSort(A, 0, N - 1);
        System.out.println(A[K - 1]);
    }

    static void merge(int[] a, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        while (i <= middle && j <= n) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = a[t];
                if ( k <= N-1) k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = a[t];
                if ( k <= N-1) k++;
            }
        }
        for (int t = m; t <= n; t++) {
            a[t] = sorted[t];
        }
    }

    static void mergeSort(int[] a, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }
}
