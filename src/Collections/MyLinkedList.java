package Collections;
import java.util.LinkedList;
public class MyLinkedList {
    static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Алибек");        // соңына қосу
        list.addFirst("Айша");     // басына қосу
        list.addLast("Нұрлан");    // соңына қосу
        list.add(1, "Бек");        // 1-орынға қосу


        list.get(0);       // 0-орындағы элемент
        list.getFirst();   // бірінші элемент
        list.getLast();    // соңғы элемент
        list.size();       // өлшемі
        list.contains("Алибек");

//
//        list.remove();          // бірінші элементті жою
//        list.removeFirst();     // бірінші элементті жою
//        list.removeLast();      // соңғы элементті жою
//        list.remove("Айша");    // мәні бойынша жою
//        list.remove(1);         // индексі бойынша жою
        list.forEach(System.out::println);

        // Stack — LIFO (соңғы кірген, бірінші шығады)
        // Мысалы: браузер тарихы

        LinkedList<String> stack = new LinkedList<>();

        // Push — қосу
        stack.push("Google.com");
        stack.push("YouTube.com");
        stack.push("GitHub.com");

        System.out.println(stack);
        // [GitHub.com, YouTube.com, Google.com]

       // Pop — соңғысын алу
        System.out.println(stack.pop()); // GitHub.com
        System.out.println(stack.pop()); // YouTube.com
// ////////////////////////////////////////////

        // Queue — FIFO (бірінші кірген, бірінші шығады)
        // Мысалы: кезек

        LinkedList<String> queue = new LinkedList<>();

        // offer — кезекке қосу
        queue.offer("Алибек");
        queue.offer("Айша");
        queue.offer("Нұрлан");

        System.out.println(queue);
        // [Алибек, Айша, Нұрлан]

        // poll — бірінші шығару
        System.out.println(queue.poll()); // Алибек
        System.out.println(queue.poll()); // Айша

        LinkedList<String> stack1 = new LinkedList<>();
        stack1.push("BEKO.com");
        stack1.push("ZEKO.com");
        stack1.push("WEKO.com");
        stack1.push("SEKO.com");
        System.out.println(stack1);
        System.out.println(stack1.getFirst());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.print("Қалған сайттар");
        System.out.println(stack1);


     }
}
