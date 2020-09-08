package sort;

import javax.sound.sampled.Line;
import java.util.*;

public class Sort {

    //通过改变下标来改变排列的顺序
    public static void bubbleSort()
    {
        int[] array = {1,2,3,4,6,7,5};
        int temp = 0;
        //冒泡排序是相邻两个的数进行排序 然后比较大小将最大或者最小放到最前面或者
        //最后面 因此每次循环之后内循环都会减少一次
        //外围循环是 有n 个数就要循环n-1次至少
        //内循环 根据外循环的数值的增加 内循环次数也在减少
        for(int i=0; i<array.length - 1; i++)
        {
            for(int j=0; j<array.length - 1 - i; j++)
            {
                if(array[j]<array[j+1])  //从小到大
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort()
    {
        int[] array = {1,2,3,4,6,7,5};
        int temp = 0;
        //选取未排序的最大值 对下标的操作 记录下标
        //找到最大值的下标 然后将这个值和顺序的下标交换
        for(int i=0; i<array.length-1; i++)
        {
            int max = i;
            for(int j=i+1 ; j<array.length; j++)
            {
                if(array[max]<array[j])
                {
                    max = j;
                }
            }
            temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
    //插入排序
    public static void insertSor()
    {
        int[] array = {1,2,3,4,6,7,5};
        //插入排序
        //将数组分成有序和无序队列 从无序队列中拿出一个数，通过和有序队列比较插入到有序队列里面
        //不过这个实在原数组上进行操作 需要变量来记录有序的index 和 获取的无序队列的值
        //认为第一个数组元素是有序队列
        int preIndex = 0;
        int current = 0;
        for(int i=1; i<array.length; i++) //要取到最后一个
        {
            preIndex = i-1 ;  //
            current = array[i]; //当前要比较的值肯定是比有序队列最后的index+1的

            //遍历从有序的最后一个位置开始
            //由于不知道有序数组的大小 循环只能通过while结束
            //结束条件preIndex <0 或者 array[preindex]<current 这时候就需要将current插入到preIndex这个位置
            //[3, 8, 0, 3, 3, 3, 6, 7, 3]
            while(preIndex>=0 && current > array[preIndex]) //要循环preindex后面的数
            {
                array[preIndex + 1] = array[preIndex]; //将末尾大的数往后挪一位
                preIndex = preIndex - 1; //准备有序的下一
            }
            //出循环之后要将数值插入
            array[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(array));
        //空间复杂度o(1)
        //时间复杂度o(n*n/2)  o(n2) 最好是o(n)
    }

    //希尔排序
    //将数组分成若干个序列数组 对每个序列的数组相互之间进行比较
    //外部循环就是 分到最后一个 不能在分了 gap < 时不能再分了
    public static void shellSort()
    {
        int[] array = {1,2,3,4,6,7,5};
        for(int gap =(array.length/2); gap>0; gap = gap/2)
        {
            for(int i=gap; i<array.length; i++)
            {
                int j = i;
                int current = array[i];
                while(j -gap >=0 && current < array[j-gap])  //两个组 相对位置进行比较 位置正好相差gap
                {
                    array[j] = array[j-gap]; //
                    j = j - gap; //进入下一个是否能比较 不能比较就退出
                }
                array[j] = current;  //操作j即可
            }
        }
        System.out.println(Arrays.toString(array));
        //算法时间复杂度平均小于O(n2) 最好O(n)
    }

    //归并排序
    //将数组分成若干数组 然后将若干数组排好序之后，再各个数组之间进行排序
    //最后进行合并的时候进行比较
    //使用递归的方法
    //{1,2,3,4,5,6};
    public static int[]  mergeSort(int[] array)
    {
        //子问题就是数组只有一个值的时候
        if(array.length < 2) return array;
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(left),mergeSort(right)); //使用递归
    }
    //有顺序的合并两个数组
    //将排好序的两个数组合并起来
    public static int[] merge(int[] left,int[] right)
    {
        int[] res = new int[left.length + right.length];

        for(int index=0,i=0,j=0; index < res.length; index ++) //一直填满这个数组
        {
            if(i>=left.length)
            {
                //可能只剩下right了
                res[index] = right[j++];
            }
            else if(j>=right.length)
            {
                res[index] = left[i++]; //只剩下left了
            }
            else if(left[i] < right[j])
            {
                //小的放前面
                res[index] = left[i++];
            }
            else
            {
                res[index] = right[j++]; //先试用 后++
            }
        }
        return res;
    }

    public static void mergeSortTest()
    {
        int[] cc = new int[10];
        for(int i=0; i<10; i++)
        {
            cc[i]  = (int)(Math.random() * 10);
        }
        System.out.println(Arrays.toString(cc));
        int[] array = {1,2,3,4,6,7,5};
        int[] b =  mergeSort(cc);
        System.out.println(Arrays.toString(b));
    }

}
