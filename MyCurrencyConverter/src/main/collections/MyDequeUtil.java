package my.collections;

public class MyDequeUtil {
  public static <T> MyDeque<T> merge(MyDeque<? extends T> d1, MyDeque<? extends T> d2) {
    int newCap = d1.size() + d2.size();
    MyDeque<T> result = new MyDeque<>(newCap);

    for (int i = 0; i < d1.size(); i++) {
      result.addLast(d1.get(i));
    }
    for (int i = 0; i < d2.size(); i++) {
      result.addLast(d2.get(i));
    }
    return result;
  }


  public static <T extends Comparable<? super T>>
  MyDeque<T> selectLess(MyDeque<? extends T> deque, T comp) {

    MyDeque<T> result = new MyDeque<>(deque.size());
    for (int i = 0; i < deque.size(); i++) {
      T element = deque.get(i);
      if (element.compareTo(comp) < 0) {
        result.addLast(element);
      }

    }
    return result;

  }
}

