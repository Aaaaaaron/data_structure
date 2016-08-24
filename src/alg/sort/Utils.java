package alg.sort;

/**
 * Created by taojiatao.aron on 2016/8/24.
 */
public class Utils {
    public static void swap ( int[] arr, int i, int j ) {
        int temp;
        temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }
}
