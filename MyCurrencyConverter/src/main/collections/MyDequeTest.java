package my.collections;

public class MyDequeTest {
    private static Object deque;

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>(10);

        for (int i = 0; i < 3; i++) {
            deque.addFirst(i);
        }
        System.out.println(deque);

        for (int i = 3; i < 6; i++) {
            deque.addLast(i);
        }
        System.out.println(deque);

        for (int i = 0; i < 2; i++) {
            deque.removeFirst();
        }
        System.out.println(deque);

        while (!deque.isEmpty()) {
            deque.removeLast();
        }
        System.out.println(deque);


        for (int i = 0; i < 8; i++) {
            deque.addLast(i);
        }
        System.out.println(deque);


        System.out.println(MyDequeUtil.merge(deque, deque));


        System.out.println(MyDequeUtil.selectLess(deque, 5));

        for (int element : deque) {
            System.out.print(element + ", ");
        }

    }

}


