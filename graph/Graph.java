package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final int V;
    private  int E;
    private Queue<Integer>[] adj;
    public Graph(int v)
    {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v]; //里面添加的是队列 每个index对应一个队列 类似桶
        //初始化邻接表
        for(int i=0; i<v; i++)
        {
            adj[i] = new LinkedList<>(); //使用双端队列实现队列  这样初始化就相当于顶点时连续的
        }
    }
    public int getV()
    {
        return V;
    }
    public int getE()
    {
        return E;
    }
    //添加图中的边 传入边链接的两个定点
    public void addEdge(int v,int w)
    {
        adj[v].offer(w);  //以v为定点 对应的邻接表
        adj[w].offer(v);
        this.E++; //边增加1
    }

    //得到每个顶点相连的点 也就是每个定点对应的邻接表
    public Queue<Integer> getAdj(int v)
    {
        return adj[v];
    }

}
