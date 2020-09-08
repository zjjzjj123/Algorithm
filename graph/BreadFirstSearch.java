package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstSearch {
    private boolean[] marked;
    private int count;


    //bfs是层次遍历 所以需要保存这个顶点依次对应的节点并且依次放到队列中去
    private Queue<Integer> waitQueue;

    public BreadFirstSearch(Graph g,int v)
    {
        marked = new boolean[g.getV()];
        waitQueue  = new LinkedList<>();
        bfs(g,v);

    }

    public void bfs(Graph g,int v)
    {
        marked[v] = true;
        waitQueue.offer(v);
        while(!waitQueue.isEmpty())  //树的遍历可以使用这种bfs吗
        {
            Integer wait = waitQueue.poll();
            for(Integer w : g.getAdj(wait))
            {

                if(!marked[w])
                {
                   // waitQueue.offer(w);
                    bfs(g,w);  //继续添加  下一个w的列表放到等待队列中去  //感觉这个也是dfs啊
                }
            }
        }
        count++;
    }

    public boolean getMarked(int v)
    {
        return marked[v];
    }

    public int getCount()
    {
        return count;
    }
}
