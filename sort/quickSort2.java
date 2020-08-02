package sort;

import java.util.Arrays;

public class quickSort2 {

    /**
     * 快速排序
     * @param nums
     */

    public static void quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    /**
     * 快速排序
     * @param nums
     * @param low
     * @param hight
     */
    private static void quickSort(int[] nums, int low, int hight) {
        if(low>hight){
            return;
        }
        System.out.println(Arrays.toString(nums));
        int i=low;
        int j =hight;
        int temp =nums[i];
        while (i<j){
            //先排右部分数组
            while (nums[j]>=temp && i<j){
                j--;
            }
            //比基准小的放左边
            nums[i] = nums[j];
            //后排左部分数组
            while (nums[i]<=temp && i<j){
                i++;
            }
            //比基准大的放右边
            nums[j] = nums[i];

        }
        nums[i] = temp;
        quickSort (nums,low,j-1);
        quickSort (nums,j+1,hight);
    }
}
