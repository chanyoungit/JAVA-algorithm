public class 올바른괄호 {
    boolean solution(String s) {
        char[] arr = s.toCharArray();

        int f = 0;
        int e = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                f++;
            } else {
                e++;
            }

            if (e > f) {
                return false;
            }
        }

        if (f == e) {
            return true;
        } else {
            return false;
        }
    }
}
