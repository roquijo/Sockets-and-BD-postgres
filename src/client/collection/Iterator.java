package client.collection;

public interface Iterator <T>{

    public void push(T data);

    public T pop(int index);

    public  boolean isEmpty();
}
