package org.datastructure.stack;

import java.util.Date;
import java.util.EmptyStackException;

public class Stack<T> {
    public Node<T> top;
    public Integer size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if(this.top != null)
            node.setNext(this.top);

        this.top = node;
        this.size++;
    }

    public Node<T> pop(){
        if(this.top == null)
            throw new EmptyStackException();

        Node<T> removedNode = this.top;
        this.top = this.top.getNext();
        this.size--;
        return removedNode;
    }

    public Node<T> top(){
        return this.top;
    }

    public Integer size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = this.top;
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
