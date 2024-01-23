package org.datastructure;

import org.datastructure.linkedlist.LinkedList;
import org.datastructure.queue.Queue;
import org.datastructure.stack.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(8);
        linkedList.add(5,1);
//        linkedList.add(65,0);
        linkedList.add(65,4);
        System.out.println(linkedList);
    }
}