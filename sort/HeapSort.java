package sort;

//堆 -> 完全二叉树
//堆排序
//最大堆 最小堆 那么堆头是所有里面最小的就是最大堆
//堆排序的坐标规定是从1开始  0不使用
//那么对应的堆节点和堆的子节点之间的index分别是
//parent = 1 left = parent * 2 right = parent*2 + 1
//堆具有下沉和上浮操作 终极目标是维护这个对的性质 最大或者最小的性质

import java.util.Arrays;

//堆排序是怎么
public class HeapSort {

    //声明全局变量，用于记录数组array的长度；
    static int len;
    int[] a = {6,2,4,3,1};

    public HeapSort()
    {
        System.out.println(Arrays.toString(HeapSort(a)));
    }
    /**
     * 堆排序算法
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) { //建立最大堆之后 将最大值和后面的最值交换然后，在调整即可
            swap(array, 0, len - 1);  //堆中 最前面的肯定是最大的或者是最小的
            len--; //缩小调整的范围
            adjustHeap(array, 0);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array)
    {
        //在认为是一个无序的堆  现在对堆进行调整
//        for(int i=0; i<=len/2-1;i++)// 这个是从上往下操作 因此需要也就是下沉的操作那么就需要左右节点那个节点大于父节点
        for(int i =len/2 - 1; i>=0; i--)  //建立了一个大顶堆 从下到上  简单  这里一定要从中间开始
        {
            adjustHeap(array,i); //对堆进行每个节点进行调整 因为节点的子节点是i*2 因此i只能小于2
        }
    }

    public  static void  adjustHeap(int[] array,int i)
    {
        //调整堆
        int maxIndex = i; //认为这个就是最大值的索引
        if(i*2+1<len && array[i*2+1] > array[maxIndex]) //说明根节点是不是最值 //更改最值的index
            maxIndex = i*2 + 1;
        //使用array.length可以 但是在比较取值的时候len--因此需要一个额外的len
        if(i*2 + 2 < len && array[i*2+2] > array[maxIndex])
            maxIndex = i*2+2;
        if(maxIndex != i) //说明最值改变了 //不再进入这里 说明调整完了
        {
            swap(array, maxIndex, i); //交换最值
            adjustHeap(array, maxIndex); //继续调整直到符合堆的性质  //用while也是能实现的 使用递归的形式
        }
    }
    /**
     * 建立最大堆
     * @param array
     */
//    public static void buildMaxHeap(int[] array) {
//        //从最后一个非叶子节点开始向上构造最大堆
//        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
//        for (int i = len/2 - 1 ; i >=0 ; i--) //为啥要从i最大的开始呢 因为建立最大堆吗 稳定性好
//
//        {
//            adjustHeap(array, i);
//        }
//    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
//    public static void adjustHeap(int[] array, int i) {
//        int maxIndex = i;
//        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
//        if (i * 2 + 1  < len && array[i * 2 + 1] > array[maxIndex])  //这种情况就算i = 0 也取不到 i[0] 但是index可以取到0
//            maxIndex = i * 2 + 1  ;   //感谢网友矫正，之前是i*2+1
//        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
//        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex])
//            maxIndex = i * 2 + 2 ;   //感谢网友矫正，之前是i*2+2
//        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
//        if (maxIndex != i) {
//            swap(array, maxIndex, i);
//            adjustHeap(array, maxIndex);
//        }
//    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
