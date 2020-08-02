package sort;

import org.omg.CORBA.portable.ValueOutputStream;

import java.util.Arrays;

public class CountSort {

    int[] a = {1,5,3,6,9,2,4};
    public CountSort()
    {
        System.out.println(Arrays.toString(CountingSort(a)));
    }
    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array)
    {
        int min = array[0];
        int max = array[0];

        for(int i=1; i<array.length; i++)
        {
            if(min > array[i])
                min = array[i];
            if(max < array[i])
                max = array[i];
        }

        int bias = 0 - min;
        int[] bucket = new int[max - min + 1 ];
        for(int i=0; i<array.length; i++)
        {
            bucket[array[i] + bias] ++ ;
        }

        int index=0, i=0;
        while(index < array.length)
        {
            if(bucket[i] != 0)
            {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            }
            else
            {
                i++;
            }
        }
        return array;
    }
//    public static int[] CountingSort(int[] array) {
//        if (array.length == 0) return array;
//        int bias, min = array[0], max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] > max)
//                max = array[i];
//            if (array[i] < min)
//                min = array[i];
//        }
//        bias = 0 - min;  //加个bias因为最小值 需要arrry里面的数值作为下标所以为了不超范围需要一个bias
//        System.out.println(bias);
//        int[] bucket = new int[max - min + 1];
//        Arrays.fill(bucket, 0);
//        for (int i = 0; i < array.length; i++) {
//            bucket[array[i] + bias]++;
//
//        }
//        int index = 0, i = 0;
//        while (index < array.length) {
//            if (bucket[i] != 0) {
//                array[index] = i - bias;  //在恢复的时候再-bias即可
//                bucket[i]--;
//                index++;
//            } else
//                i++;
//        }
//        return array;
//    }
}
