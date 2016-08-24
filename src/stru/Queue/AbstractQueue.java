package stru.Queue;

import java.util.*;

public abstract class AbstractQueue<E>
        extends AbstractCollection<E>
        implements java.util.Queue<E> {

    protected AbstractQueue() {
    }

    public boolean add(E e) {
        if (offer(e))
            return true;
        else
            throw new IllegalStateException("stru.Queue full");
    }

    public E remove() {
        E x = poll();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    public E element() {
        E x = peek();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        while (poll() != null)
            ;
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    //:offer
    //add:

    //element:Retrieves, but does not remove, the head of this queue 和peek唯一区别 element为空抛出异常
    //peek:Retrieves, but does not remove, the head of this queue 和element唯一区别 peek为空返回null

    //poll:Retrieves and removes the head of this queue 抛异常
    //remove:Retrieves and removes the head of this queue 返回null
}
