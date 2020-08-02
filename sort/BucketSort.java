package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    public static ArrayList<Integer> array = new ArrayList<>();


    public BucketSort()
    {
        array.add(1);
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(5);

        List l = BucketSort(array,5);
        System.out.println(Arrays.toString(l.toArray()));
    }

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        //定义了size 桶的大小 然后去计算桶的个数  垃圾
        int bucketCount = (max - min) / bucketSize + 1;

        //由于是整数 所以取值范围也就是存放的数量
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount); // 定义数列 然后数列里存放桶

        ArrayList<Integer> resultArr = new ArrayList<>(); //数组 存放结果
        for (int i = 0; i < bucketCount; i++) { //往数组中添加桶
            bucketArr.add(new ArrayList<Integer>());
        }
        //将所有的值添加到相应的桶里面去
        for (int i = 0; i < array.size(); i++) {
            //某个桶.get(数组的数值/桶的大小 也就是在这个范围内的 ).add(这个值添加进去)
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }

        //对桶里面的内容进行排序
        for (int i = 0; i < bucketCount; i++) //2
        {  //遍历每一个桶对应的数组
            if (bucketSize == 1)  //如果桶的大小等于1 也就是只能存放一种类型的数
            { // 如果带排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++) //那么直接将桶里的数据添加到结果集里面即可
                    resultArr.add(bucketArr.get(i).get(j));
            }
            else {
                if (bucketCount == 1) //桶的大小不是1 若桶数量只有一个 那么要缩小桶的大小 这样就能增加桶的数量了
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
}
