import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1920_수찾기 {
    static ArrayList<Integer> data;
    static ArrayList<Integer> search;
    static ArrayList<Integer> sorted = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        data = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) data.add(Integer.parseInt(st.nextToken()));
        mergeSort(data, 0, N - 1);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        search = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) search.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++) BSearch(data, search.get(i));
    }

    public static void BSearch(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr.get(mid) == target) {
                System.out.println("1");
                return;
            } else if (arr.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println("0");
        return;
    }

    public static void merge(ArrayList<Integer> arr, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= n) {
            if (arr.get(i) <= arr.get(j)) {
                sorted.add(arr.get(i));
                i++;
            } else {
                sorted.add(arr.get(j));
                j++;
            }
        }

        if (i > middle) {
            for (int t = j; t <= n; t++) sorted.add(arr.get(t));
        } else {
            for (int t = i; t <= middle; t++) sorted.add(arr.get(t));
        }

        for (int t = m; t <= n; t++) {
            arr.set(t, sorted.get(k));
            k++;
        }
        sorted.clear();
    }

    public static void mergeSort(ArrayList<Integer> arr, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
}
