package Queue;

import java.util.NoSuchElementException;

/**
 * Created by taojiatao.aron on 2016/8/23.
 */
public class Queue < E > {
    private final static int DEFAULT_SIZE = 10;
    private int front = 0;
    private int tail = -1;
    private int size = 0;
    private Object[] queue;

    public Queue () {
        queue = new Object[ DEFAULT_SIZE ];
    }

    public Queue ( int initSize ) {
        queue = new Object[ initSize ];
    }

    public boolean enqueue ( E obj ) {
        if ( isFull() ) {
            throw new IllegalStateException( "Queue full" );
        }
        else {
            queue[ ++tail ] = obj;
            size++;
            return true;
        }
    }

    public E dequeue () {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }
        E temp = peek();
        queue[ front++ ] = null;
        size--;
        return temp;
    }

    public E peek () {
        if ( size() > 0 ) {
            return ( E ) queue[ front ];
        }
        return null;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public boolean isFull () {
        return size == queue.length;
    }

    public int size () {
        return this.size();
    }


}
