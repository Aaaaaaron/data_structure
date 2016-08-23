package stack;

/**
 * Created by taojiatao.aron on 2016/8/23.
 */
public class Main {
    public static void main ( String[] args ) {
        Stack< String > stringStack = new Stack<>();
        stringStack.push( "1" );
        stringStack.push( "2" );
        stringStack.push( "3" );
        System.out.println( stringStack.peek() );
        stringStack.pop();
        System.out.println( stringStack.peek() );
        stringStack.pop();
        System.out.println( stringStack.peek() );
        stringStack.pop();
        System.out.println( stringStack.peek() );
        stringStack.pop();
    }
}
