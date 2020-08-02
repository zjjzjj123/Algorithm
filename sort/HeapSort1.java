package sort;

import java.util.Arrays;

public class HeapSort1 {

    //堆排序 维护堆的性质
    //堆的性质 最大堆 根节点的数值大于子节点
    public static int len;

    public HeapSort1(int[] array)
    {
        System.out.println(Arrays.toString(heapSort(array)));
    }


    public static int[] heapSort(int[] array)
    {
        len = array.length;
        if(len < 1) return array;  //小于1就返回 不是小于2 因为1个还是可以调整的
        buildHeap(array);
        while(len > 0) //每次维护一次之后 将数组最前的和最后的交换 然后去掉最后的
        {
            swap(array,0,len-1);
            len = len - 1;
            adjustHeap(array,0); //再从头调整
        }
        return array;
    }
    //创建堆
    public  static void buildHeap(int[] array)
    {
        //创建堆
        for(int i=0; i<array.length/2; i++)
        {
            adjustHeap(array,i); //因为堆的索引需要*2 因此只要  //从父节点开始遍历 然后下沉的
        }
    }
    //调整堆
    public static void adjustHeap(int[] array,int i)
    {
        //维护这个堆的性质 当i加入的时候
        //从上面开始网上调整

        int maxIndex = i; //父节点 -- > 得到子节点 如果子节点大 将子节点和父节点交换
        if(i*2 + 1<len && array[maxIndex] < array[i*2+1])
            maxIndex = i * 2 + 1; //父节点小
        if(i*2 + 2 < len && array[maxIndex] < array[i*2 + 2])
            maxIndex = i *2 + 2;
        if(maxIndex != i)
        {
            //继续循环调整堆
            swap(array,maxIndex,i);  //将大的值和父节点进行交换
            adjustHeap(array,maxIndex);  //继续下一个父节点进行
        }

    }

    public static void swap(int[] array,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }}
