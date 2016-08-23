package stack;

import java.util.Arrays;

/**
 * Created by taojiatao.aron on 2016/8/23.
 */
public class Stack < E > {
    private static final int INIT_SIZE = 2;
    private Object[] stack;
    private int index = -1;

    public Stack () {
        stack = new Object[ INIT_SIZE ];
    }

    public Stack ( int size ) {
        if ( size < 0 ) {
            throw new IllegalArgumentException();
        }
        stack = new Object[ size ];
    }


    public synchronized void push ( E obj ) {
        if ( isFull() ) {
            int newCapacity = 2 * stack.length;
            stack = Arrays.copyOf( stack, newCapacity );
        }

        stack[ ++index ] = obj;
    }

    public synchronized E pop () {
        if ( !isEmpty() ) {
            E temp = peek();
            stack[ index-- ] = null;
            return temp;
        }
        return null;
    }

    public synchronized E peek () {
        if ( !isEmpty() ) {
            return ( E ) stack[ index ];
        }
        return null;
    }

    public boolean isEmpty () {
        return index == -1;
    }

    public boolean isFull () {
        return index >= stack.length - 1;
    }
}
