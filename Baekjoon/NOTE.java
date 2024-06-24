import java.io.*;
import java.util.*;

class NOTE {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.addFirst(3);

        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }
}