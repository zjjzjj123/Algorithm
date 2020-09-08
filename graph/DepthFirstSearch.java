package graph;


//使用dfs搜索每个想要搜索的定点有几个点相连
//或者判断两个点是否相连
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g,int s)
    {
        marked = new boolean[g.getV()]; //每个定点都有可能被搜索到了
        dfs(g,s); //使用这个搜索 //将搜索的结构存放到类里面了 想知道结果直接调用即可
    }
    //使用dfs查找图中与s定点相连的定点数量
    public void dfs(Graph g,int s)
    {
        marked[s] = true;
        //遍历所有这个定点对应的节点以
        for(Integer w : g.getAdj(s))
        {
            if(!marked[w]) //说明没有搜索过
            {
                dfs(g,w); //搜索w相连的节点  自己这个节点也算上去了
            }
        }

        count++; //搜索的定点数+1  每多一层都会+1  就说明连接的数量多一个 包括间接连接
    }

    //判断w是否和s相通  如果相通 使用dfs之后就肯定将marked设置成true了
    public boolean getMarked(int w)
    {
        return marked[w];
    }

    public int getCount()
    {
        return count;  //其实我只要计算marked 有几个true也是能判断出有几个节点了指定节点间接或者直接相连的
    }


}
