public class 큰수만들기 {
    class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int len = number.length() - k;
            char[] arr = number.toCharArray();

            int start = 0;
            int index = 0;
            for (int i = 0; i < len; i++) {
                char max = '0';
                for (int j = start; j <= i + k; j++) {
                    if (max < arr[j]) {
                        max = arr[j];
                        index = j;
                    }
                }
                start = index + 1;
                sb.append(Character.toString(max));
            }

            String answer = sb.toString();
            return answer;
        }
    }
}
