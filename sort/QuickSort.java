package sort;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

//快速排序
public class QuickSort {

    int[] array = {1,2,0,4,6,7,5};
    public QuickSort()
    {
        System.out.println("进入构造器");
//        System.out.println(Arrays.toString(quickSort(array,0,array.length-1)));
    }

    /**
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition  选择基准
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));  //随机选择一个基准值的index
        int smallIndex = start - 1; //最小的坐标在开始坐标的左边
        swap(array, pivot, end);  //交换基准数值和最后一个数字 所以end位置存放了基准数值
        //int[] array = {1,2,0,4,6,7,5};
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {  //当small不再增加的时候说明arr开始大于基准了
                smallIndex++; //此时到start了 比较一次就要记录一次
                if (i > smallIndex) //当下一个循环过来的时候就需要交换i和smallindex的值就可以了
                    swap(array, i, smallIndex);
            }
        return smallIndex; //最后返回这个基准值 对应的index
    }
    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //另一种写法
    public  static void fastSort(int[] array,int l,int h)
    {
        if(l>=h)
        {
            return ;
        }
//        int pivot = l;  //其实可以直接将l作为基准 最左边的作为一个基准
        int i = l;
        int j = h;
        System.out.println(Arrays.toString(array));
        while(i<j)
        {
            if(array[j] > array[l])
            {
                j--;
            }
            else //找到j了
            {
                if (array[i] <= array[l]) {  //这里不一定稳定
                    i++;
                } else {
                    //i 和 j都找到了
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j--;
                }
            }
        }
        //第一轮交换结束 需要将pivot和和j交换作为下一次的比较pivot
        int t = array[l];
        array[l] = array[i];//应该和i交换
        array[i] = t; //i就是下一个pivot
        fastSort(array,l,i-1);
        fastSort(array,i+1,h);
    }

    public static void testFast()
    {
        int[] a = {25,84,21,47,15,27,68,35,20};
//        int[] a = {2,1,2,3,2,4}; //i=3 [2,1,2, 2,3,4] // j=2 i=2 [2,1,2]  // l=0h=1[2,1]  l=3 h=2[]
        //感觉有问题啊
        fastSort(a,0,a.length-1);     //[2 1 2]i=0,j=2  j=2  i=2      [2,1]  i=j 最后一个步骤交换的
//        sort1(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
