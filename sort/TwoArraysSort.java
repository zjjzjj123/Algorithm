package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoArraysSort {
    public static void sort()
    {

        Map m = new HashMap();

        int[][] a = {{1,2},{3,4},{2,3}};
        //1.目的：按照二维数组的中的首个元素的大小进行排序
        //2.方法：重写sort方法的比较器
        Arrays.sort(a, new Comparator<int[]>() {
            //o1 o2是a中的元素 此时就是a中的一维数组
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; //按照升序  反之降序或者不变
                //返回o1[0] - o2[0];是升序 因为若o1>o2 返回正数两者进行交换 若o1<o2 为负数两者不交换
                //返回o2[0] - o1[0];是降序 同理
                //为0 不变
            }
        });
        System.out.println(Arrays.deepToString(a));

    }
}


