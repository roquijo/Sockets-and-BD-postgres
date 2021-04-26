package client.collection;

import java.io.Serializable;

public class NodeList<T> implements Iterator<T>, Serializable {

    private static final long  serialVersionUID = 819479397570182364L;

    private Node<T> root;

    private Node<T> last;

    private  int index = 0;

    private int size = 0;

    public NodeList() {

        this.root = null;
        this.last = null;
    }

    public void remove(int index){

        Node<T> temp = root;

        if(isEmpty()) {
            return;
        }
        else if (index  == 0){
           root =  temp.getNext();
        }
        else if (index  == size){

            while (temp.getNext() != last){
                temp.getNext();
            }
            last = temp;
        }
        else{
            while (temp.getIndex() < index){
                temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    @Override
    public void push(T data) {

        Node<T> temp = new Node<>(data, null, index);

        if(isEmpty()) {
            root = temp;
        }
        else {
            last.setNext(temp);
        }
        last = temp;
        index++;
        size++;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public T pop(int index) {

        Node<T> temp = root;
        T data = null;

        if(isEmpty()) {
            return null;
        }
        for (int i = 0; i < size; i++)
        {
            if (temp.getIndex() == index)
            {
                data = temp.getData();
                return data;
                }
                temp = temp.getNext();
            }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}