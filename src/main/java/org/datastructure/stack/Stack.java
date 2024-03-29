package org.datastructure.stack;

import org.datastructure.Node;

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
        if(this.isEmpty())
            node.setNext(this.top);

        this.top = node;
        this.size++;
    }

    public Node<T> pop(){
        if(this.isEmpty())
            throw new EmptyStackException();

        Node<T> removedNode = this.top;
        this.top = this.top.getNext();
        this.size--;
        return removedNode;
    }

    public Node<T> top(){
        return this.top;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public Integer size(){
        return this.size;
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
