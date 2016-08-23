/**
 * Created by taojiatao.aron on 2016/8/23.
 */
public class Stack {
    private int[] array = new int[ 5 ];
    private int top = -1;

    public boolean isEmpty () {
        if ( top == -1 ) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean push ( int x ) {
        if ( top <= array.length - 1 ) {
            array[ ++top ] = x;
            return true;
        }
        else {
            return false;
        }
    }

    public int pop () {
        int number = -1;
        if ( isEmpty() ) {
            return -1;
        }
        else {
            number = top;
        }

    }

}
