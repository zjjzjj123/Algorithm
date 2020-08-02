package sort;

public class SortMeger {

    public static void test()
    {
        int[] a = {25,84,21,47,15,27,68,35,20};
    }

    public void reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return;
        }

        //不加这个就相当于一个归并排序了
//        int[] copy = new int[len];
//        for (int i = 0; i < len; i++) {
//            copy[i] = nums[i];
//        }

        int[] temp = new int[len];
        reversePairs(nums, 0, len - 1, temp);
//        return reversePairs(nums, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private void reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
//        int leftPairs = reversePairs(nums, left, mid, temp);
//        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        reversePairs(nums, left, mid, temp);  // 需要归并的子数组 每次都分成一般
        reversePairs(nums, mid + 1, right, temp);

//        if (nums[mid] <= nums[mid + 1]) {
//            return leftPairs + rightPairs;
//        }

//        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        mergeAndCount(nums, left, mid, right, temp);
//        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];  //都复制到了temp里 所以对nums可以任意操作
        }

        int i = left;
        int j = mid + 1;  //mid用来判断是否归并完成

//        int count = 0;
        for (int k = left; k <= right; k++) { //避免不稳定

            if (i == mid + 1) { //说明左边的数组归并完成
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) { //说明右边的数组归并完成
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
//                count += (mid - i + 1); //只在归并右边的时候计算出左边还有多少个数值
            }
        }
//        return count;
    }
}
