package Week_01;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 作业1 用新的API把程序重新 即原来程序使用的是push和pop，现在改为使用add/remove这套API
 * 这里直接使用两个不同的静态方法，分为两种写法，最终的效果是一致的 Deque的使用Demo
 */
public class DequeDemo {

  void dequeOldVersion() {
    Deque<String> deque = new LinkedList<>();
    deque.push("a");
    deque.push("b");
    deque.push("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }
    System.out.println(deque);
  }
  void dequeNewVersion(){
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    System.out.println(deque);

    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.removeFirst());
    }
    System.out.println(deque); 
  }

  public static void main(String[] args) {
    DequeDemo demo = new DequeDemo();
    demo.dequeOldVersion();
    demo.dequeNewVersion();

  }
}