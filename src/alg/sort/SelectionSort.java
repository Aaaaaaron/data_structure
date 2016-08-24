package alg.sort;

import static alg.sort.Utils.swap;
/*
不用中间变量交换两个数 如果太大 会溢出
{
    a = a+b;
    b = a - b;//是原来的a
    a = a - b;//b是原来的a了,所以a+b-a就是b 交换了两个数据
}
用异或
{
    if (a != b) { // a等于b的时候 异或变成0
        a ^= b;
        b ^= a;
        a ^= b;
    }
}
 */
public class SelectionSort {
    public static void sort ( int[] arr ) {
        int min;
        for ( int i = 0 ; i < arr.length ; i++ ) {
            min = i;
            for ( int j = i + 1 ; j < arr.length ; j++ ) {
                if ( arr[ j ] < arr[ i ] ) {
                    min = j;
                }
            }
            swap( arr, i, min );
        }
    }

    public static void main ( String[] args ) {
        int[] number = { 95 , 45 , 15 , 78 , 84 , 51 , 24 , 12 };
        sort( number );
        for ( int i = 0 ; i < number.length ; i++ ) {
            System.out.print( number[ i ] + " " );
        }
    }
}
