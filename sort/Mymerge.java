package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Mymerge {

    public static void test()
    {
//        int[] a = {5,2,6,1};
        int[] a = {25,84,21,47,15,27,68,35,20};
        int[] temp = new int[a.length];
        megersort(a,0,a.length-1,temp);
        System.out.println(Arrays.toString(a));
    }

    public static void megersort(int[] arr,int left,int right,int[] temp)
    {
        if(left==right)return;
        int mid = left + (right - left)/2;
        megersort(arr,left,mid,temp);
        megersort(arr,mid+1,right,temp);
        megerArray(arr,left,mid,right,temp);
    }

    public static void megerArray(int[] arr,int left,int mid,int right,int[] temp)
    {
        for(int i=left; i<=right; i++)  //right是可以取到的
        {
            temp[i] = arr[i]; //开辟新的空间 然后归并回去
        }

        int i=left;//左边开始
        int j=mid+1; //右边开始
        for(int k=left; k<=right; k++) //总共需要归并多少次
        {
            if(i>=mid+1) //说明左边的归并完成
            {
                arr[k] = temp[j];
                j++;
            }
            else if(j>=right+1)  //j可以等于right
            {
                arr[k] = temp[i];
                i++;
            }
            else if(temp[i] <= temp[j]) //维持稳定性
            {
                arr[k] = temp[i];
                i++;
            }
            else
            {
                arr[k] = temp[j];
                j++;
            }
        }
    }

//    public  static void megerSort(int[] arr,int left,int right,int[] temp)
//    {
//        if(arr.length<2) return;
//        if(left>right) return;  //返回的条件就是left = right
//        int mid = left + (right-left)/2;
//
//        megerSort(arr,left,mid,temp); //mid能取到
//        megerSort(arr,mid+1,right,temp);
//        meger(arr,left,mid,right,temp);
//    }
//    public static void meger(int[] arr,int left,int mid,int right,int[] temp)
//    {
//        if(left>right) return;
//        for(int i=left; i<=right; i++)
//        {
//            temp[i] = arr[i];
//        }
//        int i=left;
//        int j=mid+1;
//        for(int k=left; k<=right; k++)
//        {
//            if(i>=mid+1) //可以取到mid
//            {
//                arr[k] = temp[j]; //j=mid+1 mid是向下取一个所以j肯定要+1
//
//                j++;
//            }
//            else if(j>=right+1)  //j可以取到right
//            {
//                arr[k] = arr[i];
//                i++;
//            }
//            else if(temp[i] <=temp[j]) //保持稳定性
//            {
//                arr[k] = temp[i];
//                i++;
//            }
//            else if(temp[i]>temp[j])
//            {
//                arr[k] = temp[j];
//                j++;
//            }
//        }
//    }
}
