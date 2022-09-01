package linkedList;
/*
1. The deck contains integers. Add so many elements to the deck that it becomes twice as long and symmetrical.
The first element equals the last, the second element equals the penultimate, and so on.

2. There is a linked list. Write a method that returns true if the list is a polynomial.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
            Deque deque = new Deque();
            deque.addFirst(10);
            deque.addLast(20);
            deque.addLast(30);
            Deque resultDeque = palindrom(deque);
            while (!resultDeque.isEmpty()) {
                System.out.println(resultDeque.deleteFirst());
            }
        System.out.println();
        List list = new List();
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();
        }

        private static Deque palindrom(Deque deque) {
            Deque resultDeque = new Deque();
            while (!deque.isEmpty()) {
                int temp = (int) deque.deleteLast();
                resultDeque.addFirst(temp);
                resultDeque.addLast(temp);
            }
            return resultDeque;
        }
}
