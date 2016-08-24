package alg.sort;

import static alg.sort.Utils.swap;

/**
 * Created by taojiatao.aron on 2016/8/24.
 */
public class QuickSort
{

    public static void sort ( int[] arr )
    {
        sort( arr, 0, arr.length - 1 );
    }

    public static void sort ( int[] arr, int start, int end )
    {
        if ( start >= end )
        {
            return;
        }
        int mid = arr[ end ];
        int left = start, right = end - 1;
        while ( left < right )
        {
            while ( arr[ left ] < mid && left < right )
            {
                left++;
            }
            while ( arr[ right ] >= mid && left < right )
            {
                right--;
            }
            swap( arr, left, right );
        }
        if ( arr[ left ] >= arr[ end ] )
        {
            swap( arr, left, end );
        }
        else
        {
            left++;
        }
        sort( arr, start, left - 1 );
        sort( arr, left + 1, end );
    }


    public static void main ( String[] args )
    {
        int[] number = { 95 , 45 , 15 , 78 , 84 , 51 , 24 , 12 };
        sort( number );
        for ( int aNumber : number )
        {
            System.out.print( aNumber + " " );
        }
    }
}
