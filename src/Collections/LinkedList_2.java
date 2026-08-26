package Collections;

import java.util.LinkedList;

public class LinkedList_2 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        queue.poll();
        queue.poll();
        System.out.println(queue);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
