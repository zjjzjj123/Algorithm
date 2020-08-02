package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

    public static void arraysort()
    {
        int[][] array = {{10,16}, {2,8}, {1,6}, {7,12}};
        ArrayList<int[]> ar1 = new ArrayList<>();
        int[] ar2 = {1,2};

         Arrays.sort(array, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 升序排序
            }
        });
        System.out.println(Arrays.deepToString(array));

    }
}
