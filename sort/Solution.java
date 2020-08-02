package sort;

import java.util.Arrays;

public class Solution {
        int[] g = {1,2};
        int[] s = {1,2,3};

        public Solution()
        {
            System.out.println(findContentChildren(g,s));
        }
        public int findContentChildren(int[] g, int[] s) {
            //局部最优解决问题 得到较优解
            //可以根据饼干的大小和胃口比较 只要满足这个小孩就将这个饼干分给他
            //也可以优先根据小孩胃口的小从饼干去寻找 然后将这个饼干分给他
            //主要是一个饼干只能分享一次 一个小孩也只能拥有一块饼干
            // if(g.length < 1 || int s.length < 1) return null;
            Arrays.sort(g);  //先排序
            Arrays.sort(s);
            System.out.println(Arrays.toString(g));
            System.out.println(Arrays.toString(s));
            int slen = s.length;
            int glen = g.length;

            //从饼干开始比较  如果满足这个孩子饼干就+1 孩子也+1 如果不满足饼干+1 孩子不用
            //因为满足不了前面的后面的肯定也满足不了 直到 孩子或者饼干遍历完
            int sj = 0;
            int gi = 0;
            while(sj < slen && gi < glen)  //他们两个都要小于啊
            {
                if(g[gi] <= s[sj])  //为啥还能来到这里呢
                {
                    gi = gi + 1;
                }
                sj = sj+1; //如果不能满足 就把饼干往后挪即可
            }
            return gi;
        }
}
