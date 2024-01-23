package org.datastructure.queue;

import org.datastructure.Node;

public class Queue<T> {
    private Node<T> last;
    private Integer size;

    public Queue(){
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T data){
        Node<T> node = new Node<>(data);
        if(!this.isEmpty())
            node.setNext(this.last);

        this.last = node;
        this.size++;
    }

    public Node<T> dequeue(){
        if(this.isEmpty()){
            return null;
        }

        Node<T> current = this.last;

        if(this.size == 1){
            this.last = null;
            this.size--;
            return current;
        }

        Node<T> auxNode = this.last;

        while (current.getNext() != null){
            auxNode = current;
            current = current.getNext();
        }

        auxNode.setNext(null);
        this.size--;
        return current;
    }

    public Node<T> peak(){
        if(this.isEmpty()) return null;

        Node<T> current = this.last;

        while(current.getNext() != null){
            current = current.getNext();
        }

        return current;
    }

    public Integer size(){
        return this.size;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append('[');

        Node<T> current = this.last;

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
