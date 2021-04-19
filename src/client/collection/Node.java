package client.collection;

import java.io.Serializable;

public class Node<T> implements Serializable {

    private static final long  serialVersionUID = 262709397570182364L;
    private T data;
    private Node<T> next;
    private int index;

    public Node(T data, Node<T> next, int index) {

        setData(data);
        setNext(next);
        setIndex(index);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Node<T> getNext() {
        return next;
    }


    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
