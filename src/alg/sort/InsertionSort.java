package alg.sort;

import static alg.sort.Utils.swap;

// 将arr[i] 插入到arr[0]...arr[i - 1]中
public class InsertionSort
{
    public static void sort ( int[] arr )
    {
        for ( int i = 1 ; i < arr.length ; i++ )
        {
            for ( int j = i ; j > 0 && arr[ j ] < arr[ j - 1 ] ; j-- )
            {
                swap( arr, j, j - 1 );
            }
        }
    }

    public static void main ( String[] args )
    {
        int[] number = { 95 , 45 , 15 , 78 , 84 , 51 , 24 , 12 };
        sort( number );
        for ( int i = 0 ; i < number.length ; i++ )
        {
            System.out.print( number[ i ] + " " );
        }
    }
}
