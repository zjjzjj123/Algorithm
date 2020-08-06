~~~java
class Solution {
    public double myPow(double x, int n) {
        //x的n次幂 其实是(x*x) n/2次 只需要每次计算x*x 即可将n/2
        //这样就可以大大减少计算的次数 但是n/2可能是奇数 这样就会少算一个x因此
        //需要在n&1 == 1时 就是为奇数时 将结果多乘一个x
        //在返回值和接收值上面 可能需要转换精度 和 类型自动提升
        int b = n;
        //使用long接收也是可以 会自动类型提升 当出现类型不对时 要想到自动类型提升
        double ret = 1;
        if(b<0)
        {
            x = (1/x); //将负值装换成正的 并且取倒数
        }
        while(b!=0)
        {
            if((b&1) == 1) ret = ret * x; //为奇数的时候多乘一个x；
            x = x*x;
            b = b/2;
        }
        return ret;
    }
}
~~~

