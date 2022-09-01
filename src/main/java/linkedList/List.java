package linkedList;

public class List {

    private Node head;
    private Node tail;

    // Добавление элемента в конец списка
    public void add(int item) {
        Node temp = new Node();
        temp.value = item;
        if (head == null) {
            // То добавляется элемент в пустой список
            head = temp;
        } else {
            // Добавляем элемент в уже не пустой список
            tail.next = temp;
        }
        tail = temp;
    }

    public boolean isPalindrom() {
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private class Node {
        int value;
        Node next;
    }
}

