import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class NOTE {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(1);

        System.out.println(hs.size());
    }
}
