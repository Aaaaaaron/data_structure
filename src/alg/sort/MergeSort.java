package alg.sort;

/**
 * Created by taojiatao.aron on 2016/8/24.
 */
public class MergeSort
{
    //辅助数组
    private static int[] aux;

    public static void sort ( int[] arr )
    {
        aux = new int[ arr.length ];
        sort( arr, 0, arr.length - 1 );
    }

    public static void sort ( int[] a, int low, int high )
    {
        if ( high <= low )
        {
            return;
        }
        int mid = low + ( high - low ) / 2;
        sort( a, low, mid );
        sort( a, mid + 1, high );
        merge( a, low, mid, high );
    }

    public static void merge ( int[] arr, int low, int mid, int high )
    {
        int i = low, j = mid + 1;
        for ( int k = low ; k <= high ; k++ )
        {
            aux[ k ] = arr[ k ];
        }

        for ( int k = low ; k <= high ; k++ )
        {
            if ( i > mid )
            {
                arr[ k ] = aux[ j++ ];
            }
            else if ( j > high )
            {
                arr[ k ] = aux[ i++ ];
            }
            else if ( aux[ j ] < aux[ i ] )
            {
                arr[ k ] = aux[ j++ ];
            }
            else
            {
                arr[ k ] = aux[ i++ ];
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
