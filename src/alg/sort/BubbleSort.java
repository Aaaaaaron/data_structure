package alg.sort;

import static alg.sort.Utils.swap;

//这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置(一次遍历把最大数字移到最后)
//加个flag是优化,不然就算已经排序好了 还是要一个个比下去;优化外层循环
//还可以进一步的优化,记录最后一次交换的位置,这之后的数据必然都是有序的了,在内层循环比到这个位置就好了;优化内层循环
public class BubbleSort
{
    public static void sort ( int[] arr )
    {
        boolean flag = true;

        for ( int i = 0 ; ( i < arr.length - 1 ) && flag ; i++ )
        {
            flag = false;

            for ( int j = 0 ; j < arr.length - 1 - i ; j++ )
            {
                if ( arr[ j ] > arr[ j + 1 ] )
                {
                    swap( arr, j, j + 1 );
                    flag = true;
                }
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
