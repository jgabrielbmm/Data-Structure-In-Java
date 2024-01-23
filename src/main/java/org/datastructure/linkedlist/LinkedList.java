package org.datastructure.linkedlist;

import org.datastructure.Node;
import org.datastructure.exceptions.IndexOutOfRangerException;

public class LinkedList<T> {
    private Node<T> head;
    private Integer size;

    public LinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public Integer size(){
        if(this.isEmpty())
            return 0;

        Node<T> auxNode = this.head;
        Integer listSize = 0;

        while(auxNode != null){
            auxNode = auxNode.getNext();
            listSize += 1;
        }

        return listSize;
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(this.isEmpty()){
            this.head = newNode;
        }else {
            Node<T> auxNode = this.head;
            while(auxNode.getNext() != null){
                auxNode = auxNode.getNext();
            }

            auxNode.setNext(newNode);
        }
    }

    public void add(T data, int position ){

        if(position > this.size()){
            throw new IndexOutOfRangerException("Index out of linked list ranger.");
        }

        Node<T> newNode = new Node<>(data);

        if(position == 0){
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node<T> auxNode = this.head;

            for(int index = 0; index < position - 1; index++){
                auxNode = auxNode.getNext();
            }

            newNode.setNext(auxNode.getNext());
            auxNode.setNext(newNode);
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<T> current = this.head;

        while (current != null){
            sb.append(current.getData());
            if(current.getNext() != null)
                sb.append(',');
            current = current.getNext();
        }
        sb.append(']');

        return sb.toString();
    }

}
