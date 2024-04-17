import java.util.HashMap;
import java.util.HashSet;

public class 폰켓몬 {
    // HashSet 풀이
    public int solution1(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int length = nums.length / 2;
        int size = hs.size();

        if (size >= length) {
            return length;
        } else {
            return size;
        }
    }

    // HashMap 풀이
    public int solution2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, 1);
        }

        return hm.size() >= nums.length / 2 ? nums.length / 2 : hm.size();
    }
}
