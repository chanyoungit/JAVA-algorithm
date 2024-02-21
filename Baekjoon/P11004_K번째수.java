import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        quickSort(A, 0, N - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] array, int L, int R) {
        if (L >= R) return;
        int pi = partition(array, L, R);

        quickSort(array, L, pi - 1);
        quickSort(array, pi + 1, R);
    }

    public static int partition(int[] array, int L, int R) {
        int pivot = array[L];
        int i = L;
        int j = R;

        while (i < j) {
            while (pivot <= array[j]) j--;
            while (i < j && pivot >= array[i]) i++;
            swap(array, i, j);
        }
        array[L] = array[i];
        array[i] = pivot;
        return i;
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}