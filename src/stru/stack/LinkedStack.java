package stru.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by taojiatao.aron on 2016/8/23.
 */
public class LinkedStack < E > implements Iterable< E > {
    private Node< E > first;
    private int size;

    private static class Node < E > {
        E item;
        Node next;
    }

    public LinkedStack () {
        first = null;
        size = 0;
    }

    public void push ( E item ) {
        Node< E > oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    //要是数组实现这里就要考虑内存泄露了 用链表不用担心
    public E pop () {
        E item = peek();
        first = first.next;
        size--;
        return item;
    }

    public E peek () {
        if ( isEmpty() ) {
            throw new NoSuchElementException( "Stack underflow" );
        }
        return first.item;
    }

    public boolean isEmpty () {
        return first == null;
    }

    public int size () {
        return size;
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for ( E item : this ) {
            stringBuilder.append( item + " " );
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator< E > iterator () {
        return new ListIterator<>( first );
    }

    private class ListIterator < E > implements Iterator< E > {
        private Node< E > current;

        public ListIterator ( Node< E > first ) {
            this.current = first;
        }

        public boolean hasNext () {
            return current != null;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }

        public E next () {
            if (!hasNext() ) {
                if (!hasNext()) throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
