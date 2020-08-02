package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public int[] a  = {89,110,127,365,446};
    public RadixSort()
    {
        System.out.println(Arrays.toString(RadixSortFun(a)));
    }
    /**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] RadixSortFun(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        //根据最大的位数决定了需要比较几次排到桶里面
        int mod = 1, div = 10;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) //初始化10个桶 要初始化桶的数量 桶最多10个 因为 每一位最多是0-9
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10)  //从个位开始 一直到最高位
        {
            System.out.println(mod);
            //89,110,127,365,446
            //110,365,127,446,89
            //110,127,446,365,89
            //89,110,127,365,446
            for (int j = 0; j < array.length; j++)   //遍历数组的每一个数值
            {
                int num = (array[j] / mod) % div; //个位  十位  百位  ...
                bucketList.get(num).add(array[j]); //根据最后一位的不同放到不同的桶里面
            }
            //非比较的排序
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++)  //开始将桶里面的数据拿出来 ->复制到arry中
            {
                for (int k = 0; k < bucketList.get(j).size(); k++) //从最前面的桶开始取 然后每个通都要取完
                    array[index++] = bucketList.get(j).get(k);

                bucketList.get(j).clear(); //删除列表中的所有元素
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
