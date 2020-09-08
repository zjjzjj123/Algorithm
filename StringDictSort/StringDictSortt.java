package StringDictSort;


import java.util.ArrayList;
import java.util.List;

//字典序 从1-n的字典序
public class StringDictSortt {

    public  void main(String[] args) {
        //dfs 前序遍历 10叉树
        List<Integer> list = lexicalOrder(6);
    }

        // 1,2,3,4,5,6,7,8,9,10,11,12,13
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            // 保存现在整数
            int temp = 0;
            dfs(n, temp, res);
            return res;
        }

        public void dfs(int n, int tmp, List<Integer> res) {
            if(tmp > n) return;
            for(int i = 0; i <= 9; i++) {
                int pre = tmp; // 返回时还原tmp值
                tmp = tmp * 10 + i;
                if(tmp == 0) { // 去掉0特殊值
                    continue;
                }
                if(tmp > n) {
                    return;
                }
                res.add(tmp);
                dfs(n, tmp, res);
                tmp = pre;
            }
        }
}
