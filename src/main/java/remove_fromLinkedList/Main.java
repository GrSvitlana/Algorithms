package remove_fromLinkedList;
/*
1. There is a linked list with integers in it. Write a method that takes number k as a parameter.
The method has to find an element in the list with value k and remove it from the list.
Assume that such an element is necessarily in the list and it occurs there once.
Example, 1 -> 2 -> 3 -> 4 -> 5 (the original list). Call method remove(3).
1 -> 2 -> 4 -> 5 (result list).

2. Given two linked lists, storing integers in ascending order. Get a union of these two lists (third list),
in which the elements will also be sorted in ascending order.
Example, 1 -> 3 -> 5 -> 7 (first list), 0 -> 3 -> 4 (second list), 0 -> 1 -> 3 -> 3 -> 4 -> 5 -> 7 (resulting list).
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> one = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 3;
        System.out.println(removeElement(one, k));

        List<Integer> first = new LinkedList<>(Arrays.asList(1, 3, 5, 7));
        List<Integer> second = new LinkedList<>(Arrays.asList(0, 3, 4));
        System.out.println(shiftedLists(first, second));

    }

    private static List<Integer> removeElement(List<Integer> list, int k) {
        List<Integer> result = new LinkedList<>(list);
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(k)) {
                iterator.remove();
                break;
            }
        }
        return result;
    }

    private static List<Integer> shiftedLists(List<Integer> first, List<Integer> second) {
        List<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        while (i < first.size() && j < second.size()) {
            if (first.get(i) < second.get(j)) {
                result.add(first.get(i));
                i++;
            } else {
                result.add(second.get(j));
                j++;
            }
        }
        if (i < first.size()) {
            result.addAll(first.subList(i, first.size()));
        }
        if (j < second.size()) {
            result.addAll(second.subList(j, second.size()));
        }
        return result;
    }
}
